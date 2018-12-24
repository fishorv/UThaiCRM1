package com.uthai.shiro;

import com.uthai.mapper.TbPromissionMapper;
import com.uthai.mapper.TbUserRoleMapper;
import com.uthai.po.*;
import com.uthai.po.TbUserRole;
import com.uthai.po.TbUserRoleExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import bean.user;
//import dao.userdao;

public class MyRealm extends AuthorizingRealm {
    TbUserRole userRole = new TbUserRole();
    TbPromission promission = new TbPromission();
    @Resource
    TbUserRoleMapper mapper;
    @Resource
    TbPromissionMapper mapper1;
    TbUserRoleExample example= new TbUserRoleExample();
    TbPromissionExample example1=  new TbPromissionExample();
    TbUserRoleExample.Criteria criteria = example.createCriteria();
    TbPromissionExample.Criteria criteria1 = example1.createCriteria();
    /**
     * 授权:
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Object principal = principalCollection.getPrimaryPrincipal();//获取登录的用户名
        Set<String> roles =new HashSet<>();
        TbUserRole role = mapper.selectByPrimaryKey(principal.toString());
        String[] permission = role.getPromission().split(",");
        if (permission.length==0) {
            for (String r : permission) {
                roles.add(r);
            }
        } else{
            System.out.println("无此用户");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        return info;
    }

    /*
     * 用户验证
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.将token转换为UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //2.获取token中的登录账户
        String userCode = userToken.getUsername();
        //3.查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐;
        criteria.andUserIdEqualTo(userCode);
        List<TbUserRole> list=  mapper.selectByExample(example);
        for (TbUserRole r: list){
            userRole =r;
        }
        //4.1 如果没有查询到，抛出异常
        if (userRole.getOpenId()==null) {
            throw new UnknownAccountException("账户" + userCode + "不存在！");
        }
//        if( userRole.getStatus() == 0){
//            throw new LockedAccountException(us.getUsercode()+"被锁定！");
//        }
        //4.2 如果查询到了，封装查询结果，
        Object principal = userRole.getUserId();
        Object credentials = userRole.getPass().toCharArray();
        String realmName = this.getName();
        String saltS = "fishor";
        //获取盐，用于对密码在加密算法(MD5)的基础上二次加密ֵ
        Object salt = new Md5Hash(saltS);
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, byteSalt, realmName);
        //5. 返回给调用login(token)方法
        return info;
    }

    //init-method 配置.
    public void setCredentialMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//MD5算法加密
        credentialsMatcher.setHashIterations(1024);//1024次循环加密
        setCredentialsMatcher(credentialsMatcher);
    }

//
//    //用来测试的算出密码password盐值加密后的结果，下面方法用于新增用户添加到数据库操作的，我这里就直接用main获得，直接数据库添加了，省时间
    public static void main(String[] args) {
        String saltSource = "123456";
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        Object salt = new Md5Hash(saltSource);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }

}