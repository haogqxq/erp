package com.erp.service;

import com.erp.mbg.model.Holiday;
import com.erp.mbg.model.HolidayExample;

import java.util.Date;
import java.util.List;

public interface HolidayService {
    List<Holiday> getHolidays(Date startDate,Date endDate);
    Holiday getHolidayByDate(Date date);
    int deleteHolidayByDate(Date date);
    int updateHolidayByDate(Holiday record);
    int insertHoliday(Holiday record);
    HolidayExample getHolidayExample(Date date);
}
