package com.erp.service;

import com.erp.mbg.model.User;
import com.erp.mbg.model.Resource;

import java.util.List;

/**
 * 后台用户缓存操作类
 * Created by macro on 2020/3/13.
 */
public interface UserCacheService {
    /**
     * 删除后台用户缓存
     */
    void delUser(Long userId);

    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(Long userId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户信息
     */
    User getUser(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setUser(User user);

    /**
     * 获取缓存后台用户资源列表
     */
    List<Resource> getResourceList(Long userId);

    /**
     * 设置后台后台用户资源列表
     */
    void setResourceList(Long userId, List<Resource> resourceList);
}
