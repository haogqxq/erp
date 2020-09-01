package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.dto.AttendanceParam;
import com.erp.mbg.model.Attendance;
import com.erp.service.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 13:06
 * @description：考勤信息管理
 * @modified By：
 */
@Slf4j
@Controller
@RequestMapping("/attendance")
@Api(tags = "AttendanceController")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @ApiOperation(value = "取得指定用户指定日期的考勤记录")
    @GetMapping
    @ResponseBody
    public CommonResult getAttendances( @RequestBody AttendanceParam attendanceParam){
        List<Attendance> attendances =  attendanceService.getAttendanceByObject(attendanceParam);
        if (attendances!=null&&attendances.size()>0){
            return CommonResult.success(attendances);
        }
        return CommonResult.failed("没有找到考勤记录");
    }
    @ApiOperation(value = "修改指定用户指定日期的考勤")
    @PostMapping("/{id}")
    @ResponseBody
    public CommonResult update(@RequestBody Attendance attendance){
        int count = attendanceService.updateAttendanceByUsername(attendance);
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
