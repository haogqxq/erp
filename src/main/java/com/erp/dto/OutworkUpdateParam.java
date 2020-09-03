package com.erp.dto;

import com.erp.mbg.model.Leavelist;
import com.erp.mbg.model.Outwork;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description：外勤管理参数类
 */
@Data
public class OutworkUpdateParam {
    @ApiModelProperty(value = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "外勤备考")
    @NotNull(message = "外勤事由不能为空")
    private String reason;

    @ApiModelProperty(value = "审批状态")
    private String status;

    @NotNull(message = "外勤日期不能为空")
    @ApiModelProperty(value = "外勤日期")
    private Date outworkdate;

    @ApiModelProperty(value = "外勤开始时间")
    @NotNull(message = "外勤开始时间不能为空")
    private Time starttime;

    @ApiModelProperty(value = "外勤结束时间")
    @NotNull(message = "外勤结束时间不能为空")
    private Time endtime;

    public Outwork getOutwork(){
        Outwork outwork = new Outwork();
        outwork.setUsername(username);
        outwork.setOutworkdate(outworkdate);
        outwork.setStatus(status);
        outwork.setStarttime(starttime);
        outwork.setEndtime(endtime);
        outwork.setReason(reason);
        return outwork;
    }
}
