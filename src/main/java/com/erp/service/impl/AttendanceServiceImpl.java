package com.erp.service.impl;

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
 * @description：
 * @modified By：
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Override
    public List<Attendance> getAttendanceByObject(AttendanceParam attendanceParam) {
        AttendanceExample attendanceExample = new AttendanceExample();
        attendanceExample.createCriteria()
                .andUUsernameEqualTo(attendanceParam.getUsername())
                .andDutydateBetween(attendanceParam.getDutyStartDate(), attendanceParam.getDutyEndDate());
        List<Attendance> attendances = attendanceMapper.selectByExample(attendanceExample);
        if (attendances!=null && attendances.size()>0){
            return attendances;
        }
        return null;
    }

    @Override
    public int updateAttendanceByUsername(Attendance attendance) {
        int count = attendanceMapper.updateByPrimaryKeySelective(attendance);
        if (count <= 0 ){
            throw new UsernameNotFoundException("记录未找到");
        }
        return count;
    }

    @Override
    public int importMonthData(String filePath) {
        return 0;
    }
}
