package com.uthai.mapper;

import com.uthai.po.TbEmp;
import com.uthai.po.TbEmpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbEmpMapper {
    int countByExample(TbEmpExample example);

    int deleteByExample(TbEmpExample example);

    int insert(TbEmp record);

    int insertSelective(TbEmp record);

    List<TbEmp> selectByExample(TbEmpExample example);

    int updateByExampleSelective(@Param("record") TbEmp record, @Param("example") TbEmpExample example);

    int updateByExample(@Param("record") TbEmp record, @Param("example") TbEmpExample example);
}