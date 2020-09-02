package com.erp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.erp.dto.LeaveQueryParam;
import com.erp.mbg.mapper.LeavelistMapper;
import com.erp.mbg.model.Leavelist;
import com.erp.mbg.model.LeavelistExample;
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
    private LeavelistMapper leavelistMapper;
    @Override
    public List<Leavelist> getLeavesByLeaveQueryParam(LeaveQueryParam leaveQueryParem) {
        LeavelistExample leaveExample = new LeavelistExample();
        LeavelistExample.Criteria criteria = leaveExample.createCriteria();
        if (!StrUtil.isBlank(leaveQueryParem.getUsername())){
            criteria.andUUsernameEqualTo(leaveQueryParem.getUsername());
        }
        if (!StrUtil.isBlank(leaveQueryParem.getReason())){
            criteria.andReasonEqualTo(leaveQueryParem.getReason());
        }
        if (!StrUtil.isBlank(leaveQueryParem.getStatus())){
            criteria.andStatusEqualTo(leaveQueryParem.getStatus());
        }
        criteria.andLeavedateBetween(leaveQueryParem.getLeaveStartDate(),
                leaveQueryParem.getLeaveEndDate());
        List<Leavelist> leaves = leavelistMapper.selectByExample(leaveExample);
        if (leaves!=null&&leaves.size()>0){
            return leaves;
        }
        return null;
    }

    @Override
    public int insertLeave(Leavelist leavelist) {
        int count = leavelistMapper.insert(leavelist);
        return count;
    }

    @Override
    public int updateLeave(Leavelist leavelist) {
        LeavelistExample leaveExample = new LeavelistExample();
        leaveExample.createCriteria()
                .andUUsernameEqualTo(leavelist.getuUsername())
                .andLeavedateEqualTo(leavelist.getLeavedate())
                .andReasonEqualTo(leavelist.getReason());
        List<Leavelist> rawLeaveLists = leavelistMapper.selectByExample(leaveExample);
        int count = 0;
        if (rawLeaveLists!=null&&rawLeaveLists.size()>0) {
            leavelist.setId(rawLeaveLists.get(0).getId());
            leavelist.setModifiedat(new Date());
            leavelist.setCreateat(rawLeaveLists.get(0).getCreateat());
            count = leavelistMapper.updateByExample(leavelist, leaveExample);
        }
        return count;
    }

    @Override
    public int deleteLeave(String username, Date date) {
        LeavelistExample leaveExample = new LeavelistExample();
        leaveExample.createCriteria()
                .andUUsernameEqualTo(username)
                .andLeavedateEqualTo(date);
        int count = leavelistMapper.deleteByExample(leaveExample);
        return count;
    }
}
