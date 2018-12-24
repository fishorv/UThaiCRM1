package com.uthai.mapper;

import com.uthai.po.Token;
import com.uthai.po.TokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.annotation.PostConstruct;

public interface TokenMapper {

    int countByExample(TokenExample example);

    int deleteByExample(TokenExample example);

    int insert(Token record);

    int insertSelective(Token record);

    List<Token> selectByExample(TokenExample example);

    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

    int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);
}