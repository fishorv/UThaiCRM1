package com.uthai.service.impl;

import com.uthai.mapper.TokenMapper;
import com.uthai.po.Token;
import com.uthai.po.TokenExample;
import com.uthai.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    TokenMapper mapper;
    TokenExample example = new TokenExample();
    @Override
    public Token selectToken() {
        Token token= new Token();
        List<Token> list = mapper.selectByExample(example);
        for (Token t:list){
            token=t;
        }
        return token;
}

    @Override
    public int updateToken(String rtoken, long time,String expiresIn) {
        int result=1;
        try {
            Token token= new Token();
            token.setAccessToken(rtoken);
            token.setCreateTime(System.currentTimeMillis());
            token.setExpiresIn(expiresIn);
            mapper.updateByExample(token,example);
        } catch (Exception e){
            result = 0;
        }
        return result;
    }

    @Override
    public int insertToken(String rtoken,long time, String expiresIn) {
        int result = 1;
        try {
            Token token= new Token();
            token.setAccessToken(rtoken);
            token.setCreateTime(System.currentTimeMillis());
            token.setExpiresIn(expiresIn);
            mapper.insert(token);
        } catch (Exception e){
            result = 0;
        }
        return result;
    }
}
