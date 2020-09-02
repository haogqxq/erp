package com.erp.mbg.mapper;

import com.erp.mbg.model.Leavelist;
import com.erp.mbg.model.LeavelistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavelistMapper {
    int countByExample(LeavelistExample example);

    int deleteByExample(LeavelistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Leavelist record);

    int insertSelective(Leavelist record);

    List<Leavelist> selectByExample(LeavelistExample example);

    Leavelist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Leavelist record, @Param("example") LeavelistExample example);

    int updateByExample(@Param("record") Leavelist record, @Param("example") LeavelistExample example);

    int updateByPrimaryKeySelective(Leavelist record);

    int updateByPrimaryKey(Leavelist record);
}