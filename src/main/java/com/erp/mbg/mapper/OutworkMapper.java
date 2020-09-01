package com.erp.mbg.mapper;

import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.OutworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutworkMapper {
    int countByExample(OutworkExample example);

    int deleteByExample(OutworkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Outwork record);

    int insertSelective(Outwork record);

    List<Outwork> selectByExample(OutworkExample example);

    Outwork selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Outwork record, @Param("example") OutworkExample example);

    int updateByExample(@Param("record") Outwork record, @Param("example") OutworkExample example);

    int updateByPrimaryKeySelective(Outwork record);

    int updateByPrimaryKey(Outwork record);
}