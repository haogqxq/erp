package com.erp.controller;

import com.erp.common.api.CommonPage;
import com.erp.common.api.CommonResult;
import com.erp.dto.UserLoginParam;
import com.erp.dto.UserParam;
import com.erp.mbg.model.User;
import com.erp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:26
 * @description：
 * @modified By：
 */
@Slf4j
@Controller
@RequestMapping("/user")
@Api(tags = "UserController", description = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult<User> register(@Validated @RequestBody UserParam userParam){
        log.info("register");
        User user = userService.register(userParam);
        if (user==null){
            return CommonResult.failed();
        }
        return CommonResult.success(user);
    }
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UserLoginParam userLoginParam){
        log.info("login");
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token==null){
            return CommonResult.failed("用户名或者密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
