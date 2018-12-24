package com.uthai.service.impl;

import com.uthai.mapper.TbUserRoleMapper;
import com.uthai.po.TbUserRole;
import com.uthai.po.TbUserRoleExample;
import com.uthai.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    TokenImpl tokenimpl;
    @Resource
    TbUserRoleMapper tbUserRoleMapper;
    @Override
    public int register(String openid) {
//        String token=tokenimpl.getTokenString();
        ApplicationContext acc= new ClassPathXmlApplicationContext("applicationContext.xml");
        TbUserRole userRole= (TbUserRole) acc.getBean("tbUserRole");
//        TbUserRoleExample userRoleExample = (TbUserRoleExample) acc.getBean("tbUserRoleExample");
//        TbUserRoleExample.Criteria criteria = userRoleExample.createCriteria();
//        tbUserRoleMapper.selectByExample(userRoleExample);
        List<TbUserRole> list = tbUserRoleMapper.selectAll();
        for (TbUserRole t:list){
            if (openid.equals(t.getOpenId()))
                return 1;
        }
        userRole.setOpenId(openid);
        userRole.setUserId(openid.replace("s",""));
        userRole.setPass("321645");
        userRole.setBranchGroup("gx");
        userRole.setPromission("p1,p2,p3");
        userRole.setUserRole("boss");
        tbUserRoleMapper.insert(userRole);
        return 0;
    }
}
