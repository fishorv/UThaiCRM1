package com.uthai.mapper;

import com.uthai.po.TbBranch;
import com.uthai.po.TbBranchExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBranchMapper {
    int countByExample(TbBranchExample example);

    int deleteByExample(TbBranchExample example);

    int deleteByPrimaryKey(String branchId);

    int insert(TbBranch record);

    int insertSelective(TbBranch record);

    List<TbBranch> selectByExample(TbBranchExample example);

    TbBranch selectByPrimaryKey(String branchId);

    int updateByExampleSelective(@Param("record") TbBranch record, @Param("example") TbBranchExample example);

    int updateByExample(@Param("record") TbBranch record, @Param("example") TbBranchExample example);

    int updateByPrimaryKeySelective(TbBranch record);

    int updateByPrimaryKey(TbBranch record);
}