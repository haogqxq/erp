package com.erp.dao;

import com.erp.dto.AttendanceImportExcel;
import com.erp.mbg.model.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description：从Excel导入的数据插入到考勤记录表中
 */
public interface AttendanceImportExcelDAO {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<AttendanceImportExcel> list);
}
