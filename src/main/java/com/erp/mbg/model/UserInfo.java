package com.erp.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机号码")
    private Integer phone;

    @ApiModelProperty(value = "性别：0->未知；1->男；2->女")
    private Integer sex;

    @ApiModelProperty(value = "入职时间")
    private Date entrytime;

    @ApiModelProperty(value = "出生年月日")
    private Date birthdate;

    @ApiModelProperty(value = "部门")
    private Integer department;

    @ApiModelProperty(value = "职位")
    private Integer positionid;

    @ApiModelProperty(value = "创建时间")
    private Date createat;

    @ApiModelProperty(value = "修改时间")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
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
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", entrytime=").append(entrytime);
        sb.append(", birthdate=").append(birthdate);
        sb.append(", department=").append(department);
        sb.append(", positionid=").append(positionid);
        sb.append(", createat=").append(createat);
        sb.append(", modifiedat=").append(modifiedat);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}