package com.erp.dao;

import com.erp.mbg.model.UserRoleRelation;
import com.erp.mbg.model.Permission;
import com.erp.mbg.model.Resource;
import com.erp.mbg.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:26
 * @description：用户角色关系
 */
public interface UserRoleRelationDao{
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UserRoleRelation> userRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<Role> getRoleList(@Param("userId") Long userId);

    /**
     * 获取用户所有角色权限
     */
    List<Permission> getRolePermissionList(@Param("userId") Long userId);

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<Permission> getPermissionList(@Param("userId") Long userId);

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(@Param("userId") Long userId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getUserIdList(@Param("resourceId") Long resourceId);
}
