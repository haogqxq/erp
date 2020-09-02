package com.erp.service;

import com.erp.dto.LeaveQueryParem;
import com.erp.mbg.model.Leave;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：请假管理Service
 */
public interface LeaveService {
    /**
     * 查询指定日期范围的指定用户的请假记录
     */
    List<Leave> getLeavesByLeaveQueryParem(LeaveQueryParem leaveQueryParem);
    /**
     * 插入一条请假记录
     * @param leave
     * @return
     */
    int insertLeave(Leave leave);

    /**
     * 更新一条请假记录
     * @param leave
     * @return
     */
    int updateLeave(Leave leave);

    /**
     * 删除一条请假记录
     * @param username
     * @param date
     * @return
     */
    int deleteLeave(String username,Date date);
}
