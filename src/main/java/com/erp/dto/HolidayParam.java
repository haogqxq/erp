package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 16:34
 * @description：
 * @modified By：
 */
@Data
public class HolidayParam {
    @ApiModelProperty(value = "开始日期",required = true)
    @NotEmpty
    private Date StartDate;

    @ApiModelProperty(value = "结束日期",required = true)
    @NotEmpty
    private Date EndDate;
}
