package com.erp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Attendance implements Serializable {
    private Long id;

    @ApiModelProperty(value = "工号")
    private String uUsername;

    @ApiModelProperty(value = "上班日期")
    private Date dutydate;

    @ApiModelProperty(value = "上班时间")
    private Time starttime;

    @ApiModelProperty(value = "下班时间")
    private Time endtime;

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

    public Date getDutydate() {
        return dutydate;
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uUsername=").append(uUsername);
        sb.append(", dutydate=").append(dutydate);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}