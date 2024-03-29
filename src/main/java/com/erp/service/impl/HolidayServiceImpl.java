package com.erp.service.impl;

import com.erp.dto.HolidayUpdateParam;
import com.erp.mbg.mapper.HolidayMapper;
import com.erp.mbg.model.Holiday;
import com.erp.mbg.model.HolidayExample;
import com.erp.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/1 15:56
 * @description：节假日Service实现类
 */
@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayMapper holidayMapper;
    @Override
    public List<Holiday> getHolidays(Date startDate,Date endDate) {
        HolidayExample holidayExample = new HolidayExample();
        holidayExample.createCriteria().andHolidayBetween(startDate, endDate);
        List<Holiday> holidays = holidayMapper.selectByExample(holidayExample);
        if (holidays!=null&&holidays.size()>0){
            return  holidays;
        }
        return null;
    }

    @Override
    public Holiday getHolidayByDate(Date date) {
        HolidayExample holidayExample = new HolidayExample();
        holidayExample.createCriteria().andHolidayEqualTo(date);
        List<Holiday> holidays = holidayMapper.selectByExample(getHolidayExample(date));
        if (holidays!=null&&holidays.size()>0){
            return holidays.get(0);
        }
        return null;
    }

    @Override
    public int deleteHolidayByDate(Date date) {
        int count = holidayMapper.deleteByExample(getHolidayExample(date));
        return count;
    }

    @Override
    public int updateHolidayByDate(HolidayUpdateParam record) {
        Holiday holiday = new Holiday();
        holiday.setHoliday(record.getHoliday());
        holiday.setName(record.getName());
        int count = holidayMapper.updateByExample(holiday,getHolidayExample(record.getHoliday()));
        return count;
    }

    @Override
    public int insertHoliday(HolidayUpdateParam record) {
        Holiday holiday = new Holiday();
        holiday.setHoliday(record.getHoliday());
        holiday.setName(record.getName());
        int count = holidayMapper.insert(holiday);
        return count;
    }

    @Override
    public HolidayExample getHolidayExample(Date date) {
        HolidayExample holidayExample = new HolidayExample();
        holidayExample.createCriteria().andHolidayEqualTo(date);
        return holidayExample;
    }
}
