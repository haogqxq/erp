package com.erp.service;

import com.erp.mbg.model.Resource;

import java.util.List;

/**
 * 后台资源管理Service
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/30 20:12
 */
public interface ResourceService {
    /**
     * 添加资源
     */
    int create(Resource Resource);

    /**
     * 修改资源
     */
    int update(Long id, Resource Resource);

    /**
     * 获取资源详情
     */
    Resource getItem(Long id);

    /**
     * 删除资源
     */
    int delete(Long id);

    /**
     * 分页查询资源
     */
    List<Resource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * 查询全部资源
     */
    List<Resource> listAll();
}
