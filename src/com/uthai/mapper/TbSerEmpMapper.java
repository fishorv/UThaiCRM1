package com.uthai.mapper;

import com.uthai.po.TbSerEmp;
import com.uthai.po.TbSerEmpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSerEmpMapper {
    int countByExample(TbSerEmpExample example);

    int deleteByExample(TbSerEmpExample example);

    int deleteByPrimaryKey(String serEmpId);

    int insert(TbSerEmp record);

    int insertSelective(TbSerEmp record);

    List<TbSerEmp> selectByExample(TbSerEmpExample example);

    TbSerEmp selectByPrimaryKey(String serEmpId);

    int updateByExampleSelective(@Param("record") TbSerEmp record, @Param("example") TbSerEmpExample example);

    int updateByExample(@Param("record") TbSerEmp record, @Param("example") TbSerEmpExample example);

    int updateByPrimaryKeySelective(TbSerEmp record);

    int updateByPrimaryKey(TbSerEmp record);
}