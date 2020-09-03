package com.erp.service;

import com.erp.dto.LeaveQueryParam;
import com.erp.dto.OutworkQueryParam;
import com.erp.mbg.model.Leavelist;
import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.OutworkExample;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：外勤管理Service
 */
public interface OutworkService {
    /**
     * 查询指定日期范围的指定用户的外勤记录
     */
    List<Outwork> getItems(OutworkQueryParam OutworkQueryParam);
    /**
     * 插入一条外勤记录
     */
    int insert(Outwork outwork);

    /**
     * 更新一条外勤记录
     */
    int update(Outwork outwork);

    /**
     * 删除一条外勤记录
     */
    int delete(Outwork outwork);

    OutworkExample getExample(Outwork outwork);
}
