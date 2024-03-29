package com.erp.service;

import com.erp.dto.AttendanceImportExcel;
import com.erp.dto.AttendanceParam;
import com.erp.mbg.model.Attendance;
import com.erp.mbg.model.AttendanceExample;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:40
 * @description ：考勤记录Service
 */
public interface AttendanceService {
    /**
     *查询考勤
     */
    List<Attendance> getItems(AttendanceParam attendanceParam);

    /**
     * 修改考勤
     */
    int update(Attendance attendance);

    /**
     * 导入考勤
     */
    int importMonthData(List<AttendanceImportExcel> list);

    AttendanceExample getExample(String username,Date startDate,Date endDate);
}
