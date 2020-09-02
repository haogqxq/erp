package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/31 14:40
 * @description：用户登录参数类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Validated
public class UserLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 64)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 8)
    private String password;
}
