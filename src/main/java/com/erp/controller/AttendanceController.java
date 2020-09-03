package com.erp.controller;

import com.alibaba.excel.EasyExcel;
import com.erp.common.api.CommonResult;
import com.erp.common.excel.AttendanceImportExcelListener;
import com.erp.common.exception.ParamException;
import com.erp.dto.AttendanceImportExcel;
import com.erp.dto.AttendanceParam;
import com.erp.mbg.model.Attendance;
import com.erp.service.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
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
    public CommonResult getAttendances(@Valid @RequestBody AttendanceParam attendanceParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        List<Attendance> attendances =  attendanceService.getAttendanceByObject(attendanceParam);
        if (attendances!=null&&attendances.size()>0){
            return CommonResult.success(attendances);
        }
        return CommonResult.failed("没有找到考勤记录");
    }
    @ApiOperation(value = "修改指定用户指定日期的考勤")
    @PostMapping("/{id}")
    @ResponseBody
    public CommonResult update(@Valid @RequestBody Attendance attendance
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = attendanceService.updateAttendanceByUsername(attendance);
        if (count>0){
            return CommonResult.success("success");
        }
        return CommonResult.failed("修改失败");
    }
    @PostMapping("upload")
    @ResponseBody
    public CommonResult upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream()
                , AttendanceImportExcel.class
                , new AttendanceImportExcelListener(attendanceService)).sheet().doRead();
        return CommonResult.success("success");
    }
}
