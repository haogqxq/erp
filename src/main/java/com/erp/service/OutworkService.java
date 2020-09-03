package com.erp.service;

import com.erp.dto.LeaveQueryParam;
import com.erp.dto.OutworkQueryParam;
import com.erp.mbg.model.Leavelist;
import com.erp.mbg.model.Outwork;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description：外勤管理Service
 */
public interface OutworkService {
    /**
     * 查询指定日期范围的指定用户的外勤记录
     */
    List<Outwork> getOutworksByOutworkQueryParam(OutworkQueryParam OutworkQueryParam);
    /**
     * 插入一条外勤记录
     * @param outwork
     * @return
     */
    int insertOutwork(Outwork outwork);

    /**
     * 更新一条外勤记录
     * @param outwork
     * @return
     */
    int updateOutwork(Outwork outwork);

    /**
     * 删除一条外勤记录
     * @param username
     * @param date
     * @return
     */
    int deleteOutwork(String username,Date date);
}
