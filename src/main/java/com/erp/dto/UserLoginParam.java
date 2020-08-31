package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/31 14:40
 * @description：
 * @modified By：
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;
}
