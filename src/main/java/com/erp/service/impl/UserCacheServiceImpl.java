package com.erp.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.erp.service.UserCacheService;
import com.erp.service.UserService;
import com.erp.common.service.RedisService;
import com.erp.dao.UserRoleRelationDao;
import com.erp.mbg.mapper.UserRoleRelationMapper;
import com.erp.mbg.model.User;
import com.erp.mbg.model.UserRoleRelation;
import com.erp.mbg.model.UserRoleRelationExample;
import com.erp.mbg.model.Resource;
import com.erp.service.UserCacheService;
import com.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserCacheService实现类
 * Created by macro on 2020/3/13.
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;
    @Autowired
    private UserRoleRelationDao userRoleRelationDao;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delUser(Long userId) {
        User user = userService.getItem(userId);
        if (user != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + userId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        UserRoleRelationExample example = new UserRoleRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<UserRoleRelation> relationList = userRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getUserId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        UserRoleRelationExample example = new UserRoleRelationExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<UserRoleRelation> relationList = userRoleRelationMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getUserId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> userIdList = userRoleRelationDao.getUserIdList(resourceId);
        if (CollUtil.isNotEmpty(userIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = userIdList.stream().map(userId -> keyPrefix + userId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public User getUser(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (User) redisService.get(key);
    }

    @Override
    public void setUser(User user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getUsername();
        redisService.set(key, user, REDIS_EXPIRE);
    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + userId;
        return (List<Resource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long userId, List<Resource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + userId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }
}
