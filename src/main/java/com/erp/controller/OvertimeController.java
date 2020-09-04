package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.common.exception.ParamException;
import com.erp.dto.OvertimeQueryParam;
import com.erp.dto.OvertimeUpdateParam;
import com.erp.mbg.model.Overtime;
import com.erp.service.OvertimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：加班管理控制类
 */
@Slf4j
@Controller
@RequestMapping("/overtime")
@Api(value = "OvertimeController")
public class OvertimeController {
    @Autowired
    private OvertimeService overtimeService;

    @GetMapping
    @ApiOperation(value = "取得加班记录一览")
    @ResponseBody
    public CommonResult<List<Overtime>> getOvertimes(@Valid @RequestBody OvertimeQueryParam overtimeQueryParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ParamException.getCommonResult(bindingResult);
        }
        List<Overtime> overtimes = overtimeService.getItems(overtimeQueryParam);
        if (overtimes!=null&&overtimes.size()>0){
            return CommonResult.success(overtimes);
        }
        return  CommonResult.failed("没有加班记录");
    }
    @ApiOperation(value = "更新加班申请记录")
    @PutMapping
    @ResponseBody
    public CommonResult<String> update(@Valid @RequestBody OvertimeUpdateParam overtimeUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = overtimeService.update(overtimeUpdateParam.getOvertime());
        if (count>0){
            return CommonResult.success("SUCCESS");
        }
        return CommonResult.failed("更新失败");
    }
    @ApiOperation(value = "登录加班申请记录")
    @PostMapping
    @ResponseBody
    public CommonResult<String> insert(@Valid @RequestBody OvertimeUpdateParam overtimeUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = overtimeService.insert(overtimeUpdateParam.getOvertime());
        if (count>0){
            return CommonResult.success("SUCCESS");
        }
        return CommonResult.failed("登录失败");
    }
    @ApiOperation(value = "取消加班申请")
    @DeleteMapping
    @ResponseBody
    public CommonResult<String> delete(@Valid @RequestBody OvertimeUpdateParam overtimeUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = overtimeService.cancel(overtimeUpdateParam.getOvertime());
        if (count>0){
            return CommonResult.success("SUCCESS");
        }
        return CommonResult.failed("删除失败");
    }
}
