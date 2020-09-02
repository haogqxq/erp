package com.erp.service;

import com.erp.dto.LeaveQueryParam;
import com.erp.mbg.model.Leavelist;

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
    List<Leavelist> getLeavesByLeaveQueryParam(LeaveQueryParam leaveQueryParem);
    /**
     * 插入一条请假记录
     * @param leavelist
     * @return
     */
    int insertLeave(Leavelist leavelist);

    /**
     * 更新一条请假记录
     * @param leavelist
     * @return
     */
    int updateLeave(Leavelist leavelist);

    /**
     * 删除一条请假记录
     * @param username
     * @param date
     * @return
     */
    int deleteLeave(String username,Date date);
}
