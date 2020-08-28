package com.erp.controller;

import com.erp.common.api.CommonPage;
import com.erp.common.api.CommonResult;
import com.erp.mbg.model.User;
import com.erp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取所有用户列表")
    public CommonResult<List<User>> getUserList() {
        return CommonResult.success(userService.listAllUser());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createUser(@RequestBody User User) {
        CommonResult commonResult;
        int count = userService.createUser(User);
        if (count == 1) {
            commonResult = CommonResult.success(User);
            log.debug("createUser success:{}", User);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createUser failed:{}", User);
        }
        return commonResult;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateUser(@PathVariable("id") Long id, @RequestBody User UserDto, BindingResult result) {
        CommonResult commonResult;
        int count = userService.updateUser(id, UserDto);
        if (count == 1) {
            commonResult = CommonResult.success(UserDto);
            log.debug("updateUser success:{}", UserDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateUser failed:{}", UserDto);
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteUser(@PathVariable("id") Long id) {
        int count = userService.deleteUser(id);
        if (count == 1) {
            log.debug("deleteUser success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteUser failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<User>> listUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<User> UserList = userService.listUser(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(UserList));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<User> User(@PathVariable("id") Long id) {
        return CommonResult.success(userService.getUser(id));
    }
}
