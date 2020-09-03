package com.erp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 13:49
 * @description：考勤记录导入的参数类
 */
@Data
public class AttendanceImportExcel {
    private String username;
    private Date dutydate;
    private Date starttime;
    private Date endtime;
}
