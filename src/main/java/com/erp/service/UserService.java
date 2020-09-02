package com.erp.service;

import com.erp.dto.UserParam;
import com.erp.mbg.model.Resource;
import com.erp.mbg.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:40
 * @description：用户Service
 */
public interface UserService {
    /**
     * 根据用户名获取后台管理员
     */
    User getUserByUsername(String username);
    /**
     * 注册功能
     * @param userParam
     * @return
     */
    User register(UserParam userParam);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(Long adminId);
    /**
     * 根据用户id获取用户
     */
    User getItem(Long id);

    /**
     * 更新用户信息
     */
    int update(Long id,User user);

    /**
     * 更新用户信息
     * @param username
     * @return
     */
    int updateLoginTimeByUsername(String username);
}
