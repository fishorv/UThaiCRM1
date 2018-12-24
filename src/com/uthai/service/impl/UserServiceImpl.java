package com.uthai.service.impl;

import com.uthai.mapper.TbUserRoleMapper;
import com.uthai.po.TbUserRole;
import com.uthai.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    TbUserRoleMapper userRoleMapper;
    @Override
    public TbUserRole login(Map<String, String> map) {
        String openid=map.get("openid");
        TbUserRole userRole=userRoleMapper.selectByPrimaryKey(openid);
        if (userRole!=null){
            return  userRole;
        }
        return null;
    }

    @Override
    public int register(TbUserRole userRole) {
        int result=0;
        try {
            String saltSource = "fishor";
            String hashAlgorithmName = "MD5";
            String credentials = userRole.getPass();
            Object salt = new Md5Hash(saltSource);
            int hashIterations = 1024;
            Object pass = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
            userRole.setPass(pass.toString());
            userRoleMapper.insert(userRole);
        } catch (Exception e){
            result=1;
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param userName
     * @return 0未存在，1已存在
     */
    @Override
    public boolean checkIfExit(String userName) {
        boolean result = false;
        List<TbUserRole> list=userRoleMapper.selectAll();
        for (TbUserRole t:list){
            if (userName==t.getUserId())
            {
                result = true;
                break;
            }
        }
        return result;
    }
}
