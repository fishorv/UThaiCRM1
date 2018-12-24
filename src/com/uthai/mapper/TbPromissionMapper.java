package com.uthai.mapper;

import com.uthai.po.TbPromission;
import com.uthai.po.TbPromissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPromissionMapper {
    int countByExample(TbPromissionExample example);

    int deleteByExample(TbPromissionExample example);

    int insert(TbPromission record);

    int insertSelective(TbPromission record);

    List<TbPromission> selectByExample(TbPromissionExample example);

    int updateByExampleSelective(@Param("record") TbPromission record, @Param("example") TbPromissionExample example);

    int updateByExample(@Param("record") TbPromission record, @Param("example") TbPromissionExample example);
}