package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 13:49
 * @description：
 * @modified By：
 */
@Data
public class AttendanceParam {
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "开始日期",required = true)
    @NotEmpty
    private Date dutyStartDate;

    @ApiModelProperty(value = "结束日期",required = true)
    @NotEmpty
    private Date dutyEndDate;
}
