package com.erp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Leavelist implements Serializable {
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "请假事由")
    private String reason;

    @ApiModelProperty(value = "请假备考")
    private String info;

    @ApiModelProperty(value = "请假日期")
    private Date leavedate;

    @ApiModelProperty(value = "外出开始时间")
    private Date starttime;

    @ApiModelProperty(value = "外出结束时间")
    private Date endtime;

    @ApiModelProperty(value = "审批状态")
    private String status;

    @ApiModelProperty(value = "取消标志：0->未取消 1->已取消")
    private Boolean cancelflag;

    @ApiModelProperty(value = "申请时间")
    private Date createat;

    @ApiModelProperty(value = "申请修改时间")
    private Date modifiedat;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCancelflag() {
        return cancelflag;
    }

    public void setCancelflag(Boolean cancelflag) {
        this.cancelflag = cancelflag;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getModifiedat() {
        return modifiedat;
    }

    public void setModifiedat(Date modifiedat) {
        this.modifiedat = modifiedat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", reason=").append(reason);
        sb.append(", info=").append(info);
        sb.append(", leavedate=").append(leavedate);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", status=").append(status);
        sb.append(", cancelflag=").append(cancelflag);
        sb.append(", createat=").append(createat);
        sb.append(", modifiedat=").append(modifiedat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}