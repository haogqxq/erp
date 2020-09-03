package com.erp.service;

import com.erp.dto.OvertimeQueryParam;
import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.OutworkExample;
import com.erp.mbg.model.Overtime;
import com.erp.mbg.model.OvertimeExample;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：加班Service
 */
public interface OvertimeService {
    List<Overtime> getItems(OvertimeQueryParam overtimeQueryParam);
    /**
     * 插入一条外勤记录
     */
    int insert(Overtime overtime);

    /**
     * 更新一条外勤记录
     */
    int update(Overtime overtime);

    /**
     * 删除一条外勤记录
     */
    int delete(Overtime overtime);

    OvertimeExample getExample(Overtime overtime);
}
