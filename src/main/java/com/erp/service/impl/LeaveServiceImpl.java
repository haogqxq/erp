package com.erp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.erp.dto.LeaveQueryParem;
import com.erp.mbg.mapper.LeaveMapper;
import com.erp.mbg.model.Leave;
import com.erp.mbg.model.LeaveExample;
import com.erp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/2
 * @description：请假管理Service实现类
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;
    @Override
    public List<Leave> getLeavesByLeaveQueryParem(LeaveQueryParem leaveQueryParem) {
        LeaveExample leaveExample = new LeaveExample();
        LeaveExample.Criteria criteria = leaveExample.createCriteria();
        if (!StrUtil.isBlank(leaveQueryParem.getUUsername())){
            criteria.andUUsernameEqualTo(leaveQueryParem.getUUsername());
        }
        if (!StrUtil.isBlank(leaveQueryParem.getReason())){
            criteria.andReasonEqualTo(leaveQueryParem.getReason());
        }
        if (!StrUtil.isBlank(leaveQueryParem.getStatus())){
            criteria.andStatusEqualTo(leaveQueryParem.getStatus());
        }
        criteria.andUUsernameEqualTo(leaveQueryParem.getUUsername())
        .andLeavedateBetween(leaveQueryParem.getLeaveStartDate(),
                leaveQueryParem.getLeaveEndDate());
        List<Leave> leaves = leaveMapper.selectByExample(leaveExample);
        if (leaves!=null&&leaves.size()>0){
            return leaves;
        }
        return null;
    }

    @Override
    public int insertLeave(Leave leave) {
        int count = leaveMapper.insert(leave);
        return count;
    }

    @Override
    public int updateLeave(Leave leave) {
        LeaveExample leaveExample = new LeaveExample();
        leaveExample.createCriteria()
                .andUUsernameEqualTo(leave.getuUsername())
                .andLeavedateEqualTo(leave.getLeavedate())
                .andReasonEqualTo(leave.getReason());
        int count = leaveMapper.updateByExample(leave,leaveExample);
        return count;
    }

    @Override
    public int deleteLeave(String username, Date date) {
        LeaveExample leaveExample = new LeaveExample();
        leaveExample.createCriteria()
                .andUUsernameEqualTo(username)
                .andLeavedateEqualTo(date);
        int count = leaveMapper.deleteByExample(leaveExample);
        return count;
    }
}
