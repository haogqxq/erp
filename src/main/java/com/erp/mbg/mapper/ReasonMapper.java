package com.erp.mbg.mapper;

import com.erp.mbg.model.Reason;
import com.erp.mbg.model.ReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReasonMapper {
    int countByExample(ReasonExample example);

    int deleteByExample(ReasonExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Reason record);

    int insertSelective(Reason record);

    List<Reason> selectByExample(ReasonExample example);

    Reason selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Reason record, @Param("example") ReasonExample example);

    int updateByExample(@Param("record") Reason record, @Param("example") ReasonExample example);

    int updateByPrimaryKeySelective(Reason record);

    int updateByPrimaryKey(Reason record);
}