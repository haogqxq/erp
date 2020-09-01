package com.erp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Status implements Serializable {
    @ApiModelProperty(value = "审批状态：1待定，2已批准，3已拒绝")
    private Integer id;

    @ApiModelProperty(value = "审批状态")
    private String 状态;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String get状态() {
        return 状态;
    }

    public void set状态(String 状态) {
        this.状态 = 状态;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", 状态=").append(状态);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}