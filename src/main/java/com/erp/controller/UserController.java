package com.erp.controller;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
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

        User user = userService.register(userParam);
        if (user==null){
            return CommonResult.failed("用户注册失败");
        }
        return CommonResult.success(user);
    }
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UserLoginParam userLoginParam){
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token==null){
            return CommonResult.failed("用户名或者密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    @ResponseBody
    public CommonResult getUserInfo(Principal principal){
        if (principal==null) return CommonResult.unauthorized(null);
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        if (user==null) return CommonResult.failed("没有该用户的信息");
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("username", username);
        userInfo.put("icon", user.getIcon());
        userInfo.put("Email", user.getEmail());
        return CommonResult.success(userInfo);
    }
    @ApiOperation(value = "修改指定用户信息")
    @PostMapping(value = "/update/{id}")
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody User user){
        int count = userService.update(id, user);
        if (count>0) return CommonResult.success(count);
        return CommonResult.failed("用户信息更新失败");
    }
}
