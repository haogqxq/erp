package com.erp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.erp.dto.LeaveQueryParam;
import com.erp.dto.OutworkQueryParam;
import com.erp.mbg.mapper.OutworkMapper;
import com.erp.mbg.model.Outwork;
import com.erp.mbg.model.OutworkExample;
import com.erp.service.OutworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/9/3
 * @description ：外勤管理接口的实现类
 */
@Service
public class OutworkServiceImpl implements OutworkService {
    @Autowired
    private OutworkMapper outworkMapper;
    @Override
    public List<Outwork> getItems(OutworkQueryParam OutworkQueryParam) {
        OutworkExample outworkExample = new OutworkExample();
        OutworkExample.Criteria criteria = outworkExample.createCriteria();
        if (!StrUtil.isEmpty(OutworkQueryParam.getUsername())){
            criteria.andUsernameEqualTo(OutworkQueryParam.getUsername());
        }
        if (!StrUtil.isEmpty(OutworkQueryParam.getStatus())){
            criteria.andStatusEqualTo(OutworkQueryParam.getStatus());
        }
        criteria.andOutworkdateBetween(OutworkQueryParam.getStartDate()
                , OutworkQueryParam.getEndDate());
        List<Outwork> outworks = outworkMapper.selectByExample(outworkExample);
        if (outworks!=null&&outworks.size()>0){
            return outworks;
        }
        return null;
    }

    @Override
    public int insert(Outwork outwork) {
        outwork.setStatus("0");
        OutworkExample outworkExample = getExample(outwork);
        List<Outwork> rawOutworks = outworkMapper.selectByExample(outworkExample);
        int count = 0;
        if (rawOutworks!=null&&rawOutworks.size()>0){
            return count;
        }else {
            count = outworkMapper.insertSelective(outwork);
            return count;
        }

    }

    @Override
    public int update(Outwork outwork) {
        OutworkExample outworkExample = getExample(outwork);
        List<Outwork> rawOutworks = outworkMapper.selectByExample(outworkExample);
        int count = 0;
        if (rawOutworks!=null&&rawOutworks.size()>0){
            outwork.setId(rawOutworks.get(0).getId());
            outwork.setCreateat(rawOutworks.get(0).getCreateat());
            outwork.setModifiedat(new Date());
            count = outworkMapper.updateByExample(outwork, outworkExample);
        }
        return count;
    }

    @Override
    public int delete(Outwork outwork) {
        return outworkMapper.deleteByExample(getExample(outwork));
    }

    @Override
    public OutworkExample getExample(Outwork outwork) {
        OutworkExample outworkExample = new OutworkExample();
        outworkExample.createCriteria()
                .andUsernameEqualTo(outwork.getUsername())
                .andOutworkdateEqualTo(outwork.getOutworkdate());
        return outworkExample;
    }
}
