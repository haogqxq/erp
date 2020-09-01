package com.erp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Outwork implements Serializable {
    private Long id;

    @ApiModelProperty(value = "工号")
    private String uUsername;

    @ApiModelProperty(value = "外勤日期")
    private Date outworkdate;

    @ApiModelProperty(value = "外勤开始时间")
    private Date starttime;

    @ApiModelProperty(value = "外勤结束时间")
    private Date endtime;

    @ApiModelProperty(value = "审批状态")
    private Integer status;

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

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public Date getOutworkdate() {
        return outworkdate;
    }

    public void setOutworkdate(Date outworkdate) {
        this.outworkdate = outworkdate;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", uUsername=").append(uUsername);
        sb.append(", outworkdate=").append(outworkdate);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", status=").append(status);
        sb.append(", createat=").append(createat);
        sb.append(", modifiedat=").append(modifiedat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}