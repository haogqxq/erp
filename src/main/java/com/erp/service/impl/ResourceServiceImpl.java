package com.erp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.erp.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.erp.mbg.mapper.ResourceMapper;
import com.erp.mbg.model.Resource;
import com.erp.mbg.model.ResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台资源管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public int create(Resource Resource) {
        Resource.setCreateTime(new Date());
        return resourceMapper.insert(Resource);
    }

    @Override
    public int update(Long id, Resource Resource) {
        Resource.setId(id);
        int count = resourceMapper.updateByPrimaryKeySelective(Resource);
        return count;
    }

    @Override
    public Resource getItem(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ResourceExample example = new ResourceExample();
        ResourceExample.Criteria criteria = example.createCriteria();
        if(categoryId!=null){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if(StrUtil.isNotEmpty(nameKeyword)){
            criteria.andNameLike('%'+nameKeyword+'%');
        }
        if(StrUtil.isNotEmpty(urlKeyword)){
            criteria.andUrlLike('%'+urlKeyword+'%');
        }
        return resourceMapper.selectByExample(example);
    }

    @Override
    public List<Resource> listAll() {
        return resourceMapper.selectByExample(new ResourceExample());
    }
}
