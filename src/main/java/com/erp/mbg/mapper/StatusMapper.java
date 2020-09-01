package com.erp.mbg.mapper;

import com.erp.mbg.model.Status;
import com.erp.mbg.model.StatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusMapper {
    int countByExample(StatusExample example);

    int deleteByExample(StatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Status record);

    int insertSelective(Status record);

    List<Status> selectByExample(StatusExample example);

    Status selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Status record, @Param("example") StatusExample example);

    int updateByExample(@Param("record") Status record, @Param("example") StatusExample example);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);
}