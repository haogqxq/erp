package com.erp.service;

import com.erp.dto.AttendanceParam;
import com.erp.mbg.model.Attendance;

import java.util.Date;
import java.util.List;

/**
 * 考勤信息Service
 */
public interface AttendanceService {
    List<Attendance> getAttendanceByObject(AttendanceParam attendanceParam);
    int updateAttendanceByUsername(Attendance attendance);
    int importMonthData(String filePath);
}
