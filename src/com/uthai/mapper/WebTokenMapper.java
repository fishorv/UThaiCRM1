package com.uthai.mapper;

import com.uthai.po.WebToken;
import com.uthai.po.WebTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebTokenMapper {
    int countByExample(WebTokenExample example);

    int deleteByExample(WebTokenExample example);

    int insert(WebToken record);

    int insertSelective(WebToken record);

    List<WebToken> selectByExample(WebTokenExample example);

    int updateByExampleSelective(@Param("record") WebToken record, @Param("example") WebTokenExample example);

    int updateByExample(@Param("record") WebToken record, @Param("example") WebTokenExample example);
}