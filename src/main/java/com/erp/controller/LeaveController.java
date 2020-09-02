package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.common.exception.ParamException;
import com.erp.dto.LeaveQueryParam;
import com.erp.dto.LeaveUpdateParam;
import com.erp.mbg.model.Leavelist;
import com.erp.service.LeaveService;
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
 * @date ：Created in 2020/9/2
 * @description：请假控制类
 */
@Slf4j
@Controller
@RequestMapping("/leave")
@Api(value = "LeaveController")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @ApiOperation(value = "查询请假记录")
    @GetMapping
    @ResponseBody
    public CommonResult getLeaves(@Valid @RequestBody LeaveQueryParam leaveQueryParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        List<Leavelist> leaveLists = leaveService.getLeavesByLeaveQueryParam(leaveQueryParam);
        if (leaveLists!=null&&leaveLists.size()>0){
            return CommonResult.success(leaveLists);
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "登录请假记录")
    @PostMapping
    @ResponseBody
    public CommonResult insertLeave(@Valid @RequestBody LeaveUpdateParam leaveUpdateParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = leaveService.insertLeave(leaveUpdateParam.getLeaveList());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("请假记录登录失败");
    }
    @ApiOperation(value = "修改请假记录")
    @PutMapping
    @ResponseBody
    public CommonResult updateLeave(@Valid @RequestBody LeaveUpdateParam leaveUpdateParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = leaveService.updateLeave(leaveUpdateParam.getLeaveList());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("请假记录修改失败");
    }
    @ApiOperation(value = "修改请假记录")
    @DeleteMapping
    @ResponseBody
    public CommonResult deleteLeave(@Valid @RequestBody LeaveUpdateParam leaveUpdateParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = leaveService.deleteLeave(leaveUpdateParam.getUsername()
                ,leaveUpdateParam.getLeavedate());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("请假记录修改失败");
    }
}
