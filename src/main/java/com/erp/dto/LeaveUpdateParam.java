package com.erp.dto;

import com.erp.mbg.model.Leavelist;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：请假管理参数类
 */
@Data
public class LeaveUpdateParam {
    @ApiModelProperty(value = "用户名")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "请假事由")
    @NotNull(message = "请假事由不能为空")
    @Size(max = 2)
    private String reason;

    @ApiModelProperty(value = "请假备考")
    private String info;

    @ApiModelProperty(value = "审批状态")
    private String status;

    @NotNull(message = "请假日期不能为空")
    @ApiModelProperty(value = "请假日期")
    private Date leavedate;

    @ApiModelProperty(value = "外出开始时间")
    @NotNull(message = "请假开始时间不能为空")
    private Time starttime;

    @ApiModelProperty(value = "外出结束时间")
    @NotNull(message = "请假结束时间不能为空")
    private Time endtime;

    public Leavelist getLeaveList(){
        Leavelist leavelist = new Leavelist();
        leavelist.setUsername(username);
        leavelist.setLeavedate(leavedate);
        leavelist.setInfo(info);
        leavelist.setReason(reason);
        leavelist.setStatus(status);
        leavelist.setStarttime(starttime);
        leavelist.setEndtime(endtime);
        return leavelist;
    }
}
