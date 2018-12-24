package com.uthai.mapper;

import com.uthai.po.Openid;
import com.uthai.po.OpenidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenidMapper {
    int countByExample(OpenidExample example);

    int deleteByExample(OpenidExample example);

    int deleteByPrimaryKey(String openid);

    int insert(String openid);

    int insertSelective(Openid record);

    List<Openid> selectByExample(OpenidExample example);

    int updateByExampleSelective(@Param("record") Openid record, @Param("example") OpenidExample example);

    int updateByExample(@Param("record") Openid record, @Param("example") OpenidExample example);
}