package com.erp.service.impl;

import com.erp.mbg.mapper.UserMapper;
import com.erp.mbg.model.User;
import com.erp.mbg.model.UserExample;
import com.erp.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：haoguoqiang
 * @date ：Created in 2020/8/28 20:50
 * @description：
 * @modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int createUser(User User) {
        return userMapper.insert(User);
    }

    @Override
    public int updateUser(Long id, User User) {
        return userMapper.updateByPrimaryKeySelective(User);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
