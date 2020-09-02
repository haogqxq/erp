package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：请假管理参数类
 */
@Data
public class LeaveQueryParam {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "请假事由")
    private String reason;

    @ApiModelProperty(value = "审批状态")
    private String status;

    @ApiModelProperty(value = "查询开始日期")
    @NotNull(message = "开始日期不能为空")
    private Date leaveStartDate;

    @ApiModelProperty(value = "查询结束日期")
    @NotNull(message = "结束日期不能为空")
    private Date leaveEndDate;

}
