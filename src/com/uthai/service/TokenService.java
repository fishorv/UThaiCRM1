package com.uthai.service;

import com.uthai.po.Token;
public interface TokenService {
    Token selectToken();
    int updateToken(String rtoken,long time ,String expiresIn);
    int insertToken(String rtoken,long time,String expiresIn);

}
