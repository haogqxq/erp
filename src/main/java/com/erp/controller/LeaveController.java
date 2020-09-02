package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.common.exception.ParamException;
import com.erp.dto.LeaveQueryParem;
import com.erp.mbg.model.Leave;
import com.erp.service.LeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public CommonResult getLeaves(@Valid @RequestBody LeaveQueryParem leaveQueryParem, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        List<Leave> leaves = leaveService.getLeavesByLeaveQueryParem(leaveQueryParem);
        if (leaves!=null&&leaves.size()>0){
            return CommonResult.success(leaves);
        }
        return CommonResult.failed();
    }
}
