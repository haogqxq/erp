package com.erp.mbg.mapper;

import com.erp.mbg.model.Overtime;
import com.erp.mbg.model.OvertimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OvertimeMapper {
    int countByExample(OvertimeExample example);

    int deleteByExample(OvertimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    List<Overtime> selectByExample(OvertimeExample example);

    Overtime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByExample(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);
}