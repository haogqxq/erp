package com.erp.controller;

import com.erp.common.api.CommonResult;
import com.erp.common.exception.ParamException;
import com.erp.dto.OutworkQueryParam;
import com.erp.dto.OutworkUpdateParam;
import com.erp.mbg.model.Outwork;
import com.erp.service.OutworkService;
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
 * @description：外勤管理控制类
 */
@Controller
@Slf4j
@RequestMapping("/outwork")
@Api(value = "OutworkController")
public class OutworkController {
    @Autowired
    private OutworkService outworkService;
    @ApiOperation(value = "取得外勤记录一览")
    @GetMapping
    @ResponseBody
    public CommonResult getOutworks(@Valid @RequestBody OutworkQueryParam outworkQueryParam
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ParamException.getCommonResult(bindingResult);
        }
        List<Outwork> outworks = outworkService.getOutworksByOutworkQueryParam(outworkQueryParam);
        if (outworks!=null&&outworks.size()>0){
            return  CommonResult.success(outworks);
        }
        return CommonResult.failed("没有对应的外勤记录");
    }
    @ApiOperation(value = "更新外勤申请记录")
    @PutMapping
    @ResponseBody
    public CommonResult update(@Valid @RequestBody OutworkUpdateParam outworkUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = outworkService.updateOutwork(outworkUpdateParam.getOutwork());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("更新失败");
    }
    @ApiOperation(value = "登录外勤申请记录")
    @PostMapping
    @ResponseBody
    public CommonResult insert(@Valid @RequestBody OutworkUpdateParam outworkUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = outworkService.insertOutwork(outworkUpdateParam.getOutwork());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("登录失败");
    }
    @ApiOperation(value = "删除外勤申请记录")
    @DeleteMapping
    @ResponseBody
    public CommonResult delete(@Valid @RequestBody OutworkUpdateParam outworkUpdateParam
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ParamException.getCommonResult(bindingResult);
        }
        int count = outworkService.deleteOutwork(outworkUpdateParam.getUsername()
                , outworkUpdateParam.getOutworkdate());
        if (count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed("删除失败");
    }
}
