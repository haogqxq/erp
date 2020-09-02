package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 13:49
 * @description：考勤记录的参数类
 */
@Data
public class AttendanceParam {
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "开始日期",required = true)
    @NotNull(message = "开始日期不能为NULL")
    @Past(message = "开始日期需要是一个过去的时间")
    private Date dutyStartDate;

    @ApiModelProperty(value = "结束日期",required = true)
    @NotNull(message = "结束日期不能为NULL")
    @Past(message = "结束日期需要是一个过去的时间")
    private Date dutyEndDate;
}
