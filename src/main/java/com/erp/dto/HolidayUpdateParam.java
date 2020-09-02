package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：节假日更新删除用的参数类
 */
@Data
public class HolidayUpdateParam {
    @ApiModelProperty(value = "节假日日期")
    @NotNull(message = "节假日日期不能为空")
    private Date holiday;

    @ApiModelProperty(value = "节假日名字")
    @NotEmpty(message = "节假日名字不能为空")
    private String name;
}
