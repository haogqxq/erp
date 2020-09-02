package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.common.exception.ParamException;
import com.erp.dto.HolidayParam;
import com.erp.dto.HolidayUpdateParam;
import com.erp.mbg.model.Holiday;
import com.erp.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 16:13
 * @description：
 * @modified By：
 */
@Slf4j
@Controller
@RequestMapping("/holiday")
@Api(value = "HolidayController")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;
    @ApiOperation(value = "获取指定日期的节假日")
    @GetMapping
    @ResponseBody
    public CommonResult getHoliday(@Valid @RequestBody Holiday holiday, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        Holiday rawHoliday = holidayService.getHolidayByDate(holiday.getHoliday());
        if (rawHoliday!=null) return CommonResult.success(rawHoliday);
        return CommonResult.failed("找不到该日期的节假日");
    }
    @ApiOperation(value = "获取指定日期范围的节假日列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult getHolidays(@Valid @RequestBody HolidayParam holidayParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        List<Holiday> holidays = holidayService.getHolidays(holidayParam.getStartDate()
                , holidayParam.getEndDate());
        if (holidays!=null&&holidays.size()>0){
            return CommonResult.success(holidays);
        }
        return CommonResult.failed("没有该日期范围的节假日");
    }
    @ApiOperation(value = "登录节假日")
    @PostMapping
    @ResponseBody
    public CommonResult insertHoliday(@Valid @RequestBody HolidayUpdateParam holidayUpdateParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = holidayService.insertHoliday(holidayUpdateParam);
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("登录失败");
    }
    @ApiOperation(value = "删除节假日")
    @DeleteMapping
    @ResponseBody
    public CommonResult deleteHoliday(@Valid @RequestBody HolidayUpdateParam holidayUpdateParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = holidayService.deleteHolidayByDate(holidayUpdateParam.getHoliday());
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("删除失败");
    }
    @ApiOperation(value = "更新节假日")
    @PutMapping
    @ResponseBody
    public CommonResult updateHoliday(@Valid @RequestBody HolidayUpdateParam holidayUpdateParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = holidayService.updateHolidayByDate(holidayUpdateParam);
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("更新失败");
    }
}
