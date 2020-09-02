package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 16:34
 * @description：节假日参数类
 */
@Data
public class HolidayParam {
    @ApiModelProperty(value = "开始日期",required = true)
    @NotNull(message = "开始日期不能为NULL")
    private Date StartDate;

    @ApiModelProperty(value = "结束日期",required = true)
    @NotNull(message = "结束日期不能为NULL")
    private Date EndDate;
}
