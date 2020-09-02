package com.erp.common.exception;

import com.erp.common.api.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：参数验证异常处理类
 */
public class ParamException {
    public static CommonResult getCommonResult(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()) {
                return CommonResult.failed(error.getDefaultMessage());
            }
        }
        return CommonResult.failed();
    }
}
