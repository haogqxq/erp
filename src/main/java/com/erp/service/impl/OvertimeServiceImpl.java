package com.erp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.erp.dto.OutworkQueryParam;
import com.erp.dto.OvertimeQueryParam;
import com.erp.mbg.mapper.OvertimeMapper;
import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.OutworkExample;
import com.erp.mbg.model.Overtime;
import com.erp.mbg.model.OvertimeExample;
import com.erp.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：加班管理实现类
 */
@Service
public class OvertimeServiceImpl implements OvertimeService {
    @Autowired
    private OvertimeMapper overtimeMapper;
    @Override
    public List<Overtime> getItems(OvertimeQueryParam overtimeQueryParam) {
        OvertimeExample overtimeExample = new OvertimeExample();
        OvertimeExample.Criteria criteria = overtimeExample.createCriteria();
        if (!StrUtil.isEmpty(overtimeQueryParam.getUsername())){
            criteria.andUsernameEqualTo(overtimeQueryParam.getUsername());
        }
        if (!StrUtil.isEmpty(overtimeQueryParam.getStatus())){
            criteria.andStatusEqualTo(overtimeQueryParam.getStatus());
        }
        criteria.andOvertimedateBetween(overtimeQueryParam.getStartDate()
                , overtimeQueryParam.getEndDate());
        List<Overtime> overtimes = overtimeMapper.selectByExample(overtimeExample);
        if (overtimes!=null&&overtimes.size()>0){
            return overtimes;
        }
        return null;
    }

    @Override
    public int insert(Overtime overtime) {
        overtime.setStatus("0");
        OvertimeExample overtimeExample = getExample(overtime);
        List<Overtime> rawOvertimes = overtimeMapper.selectByExample(overtimeExample);
        int count = 0;
        if (rawOvertimes!=null&&rawOvertimes.size()>0){
            return count;
        }else {
            count = overtimeMapper.insertSelective(overtime);
            return count;
        }
    }

    @Override
    public int update(Overtime overtime) {
        OvertimeExample overtimeExample = getExample(overtime);
        List<Overtime> rawOvertimes = overtimeMapper.selectByExample(overtimeExample);
        int count = 0;
        if (rawOvertimes!=null&&rawOvertimes.size()>0){
            overtime.setId(rawOvertimes.get(0).getId());
            overtime.setCreateat(rawOvertimes.get(0).getCreateat());
            overtime.setModifiedat(new Date());
            count = overtimeMapper.updateByExample(overtime, overtimeExample);
        }
        return count;
    }

    @Override
    public int cancel(Overtime overtime) {
        OvertimeExample overtimeExample = getExample(overtime);
        List<Overtime> rawOvertimes = overtimeMapper.selectByExample(overtimeExample);
        int count = 0;
        if (rawOvertimes!=null&&rawOvertimes.size()>0){
            rawOvertimes.get(0).setCancelflag(true);
            count = overtimeMapper.updateByExample(rawOvertimes.get(0), overtimeExample);
        }
        return count;
    }

    @Override
    public OvertimeExample getExample(Overtime overtime) {
        OvertimeExample overtimeExample = new OvertimeExample();
        overtimeExample.createCriteria()
                .andUsernameEqualTo(overtime.getUsername())
                .andCancelflagEqualTo(overtime.getCancelflag())
                .andOvertimedateEqualTo(overtime.getOvertimedate());
        return overtimeExample;
    }
}
