package com.uthai.service;

import com.uthai.po.TbUserRole;

import java.util.Map;

public interface UserService {
    TbUserRole login(Map<String,String> map);
    int register(TbUserRole userRole);
    boolean checkIfExit(String userName);
}
