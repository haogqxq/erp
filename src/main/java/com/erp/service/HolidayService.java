package com.erp.service;

import com.erp.dto.HolidayUpdateParam;
import com.erp.mbg.model.Holiday;
import com.erp.mbg.model.HolidayExample;

import java.util.Date;
import java.util.List;
/**
 * @author :haoguoqiang
 * @date :Created in 2020/8/30 20:10
 * description:节假日管理Service
 */
public interface HolidayService {
    List<Holiday> getHolidays(Date startDate,Date endDate);
    Holiday getHolidayByDate(Date date);
    int deleteHolidayByDate(Date date);
    int updateHolidayByDate(HolidayUpdateParam record);
    int insertHoliday(HolidayUpdateParam record);
    HolidayExample getHolidayExample(Date date);
}
