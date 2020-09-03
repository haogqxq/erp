package com.erp.service.impl;

import com.erp.dao.AttendanceImportExcelDAO;
import com.erp.dto.AttendanceImportExcel;
import com.erp.dto.AttendanceParam;
import com.erp.mbg.mapper.AttendanceMapper;
import com.erp.mbg.model.Attendance;
import com.erp.mbg.model.AttendanceExample;
import com.erp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 12:54
 * @description ：考勤记录管理实现类
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private AttendanceImportExcelDAO attendanceImportExcelDAO;
    @Override
    public List<Attendance> getItems(AttendanceParam attendanceParam) {

        List<Attendance> attendances = attendanceMapper
                .selectByExample(getExample(attendanceParam.getUsername()
                        ,attendanceParam.getDutyStartDate()
                        ,attendanceParam.getDutyEndDate()));
        if (attendances!=null && attendances.size()>0){
            return attendances;
        }
        return null;
    }

    @Override
    public int update(Attendance attendance) {
        return attendanceMapper.updateByPrimaryKeySelective(attendance);
    }

    @Override
    public int importMonthData(List<AttendanceImportExcel> list) {
        return attendanceImportExcelDAO.insertList(list);
    }

    @Override
    public AttendanceExample getExample(String username, Date startDate, Date endDate) {
        AttendanceExample attendanceExample = new AttendanceExample();
        attendanceExample.createCriteria()
                .andUsernameEqualTo(username)
                .andDutydateBetween(startDate, endDate);
        return attendanceExample;
    }
}
