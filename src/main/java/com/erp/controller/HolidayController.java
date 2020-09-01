package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.dto.HolidayParam;
import com.erp.mbg.model.Holiday;
import com.erp.service.HolidayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult getHoliday(@RequestBody Holiday holiday){
        Holiday rawHoliday = holidayService.getHolidayByDate(holiday.getHoliday());
        if (rawHoliday!=null) return CommonResult.success(rawHoliday);
        return CommonResult.failed("找不到该日期的节假日");
    }
    @ApiOperation(value = "获取指定日期范围的节假日列表")
    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult getHolidays(@RequestBody HolidayParam holidayParam){
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
    public CommonResult insertHoliday(@RequestBody Holiday holiday){
        int count = holidayService.insertHoliday(holiday);
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("登录失败");
    }
    @ApiOperation(value = "删除节假日")
    @DeleteMapping
    @ResponseBody
    public CommonResult deleteHoliday(@RequestBody Holiday holiday){
        int count = holidayService.deleteHolidayByDate(holiday.getHoliday());
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("删除失败");
    }
    @ApiOperation(value = "更新节假日")
    @PutMapping
    @ResponseBody
    public CommonResult updateHoliday(@RequestBody Holiday holiday){
        int count = holidayService.updateHolidayByDate(holiday);
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("更细失败");
    }
}
