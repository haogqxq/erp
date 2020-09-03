package com.erp.dto;

import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.Overtime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：加班管理参数类
 */
@Data
public class OvertimeUpdateParam {
    @ApiModelProperty(value = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "加班备考")
    @NotNull(message = "外勤事由不能为空")
    private String info;

    @ApiModelProperty(value = "审批状态")
    private String status;

    @NotNull(message = "外勤日期不能为空")
    @ApiModelProperty(value = "外勤日期")
    private Date overtimedate;

    @ApiModelProperty(value = "外勤开始时间")
    @NotNull(message = "外勤开始时间不能为空")
    private Time starttime;

    @ApiModelProperty(value = "外勤结束时间")
    @NotNull(message = "外勤结束时间不能为空")
    private Time endtime;

    public Overtime getOvertime(){
        Overtime overtime = new Overtime();
        overtime.setUsername(username);
        overtime.setOvertimedate(overtimedate);
        overtime.setStatus(status);
        overtime.setStarttime(starttime);
        overtime.setEndtime(endtime);
        overtime.setInfo(info);
        return overtime;
    }
}
