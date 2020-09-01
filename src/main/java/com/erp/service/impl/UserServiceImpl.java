package com.erp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.erp.bo.UserDetail;
import com.erp.common.exception.Asserts;
import com.erp.dao.UserRoleRelationDao;
import com.erp.dto.UserParam;
import com.erp.mbg.mapper.UserLoginLogMapper;
import com.erp.mbg.mapper.UserMapper;
import com.erp.mbg.model.Resource;
import com.erp.mbg.model.User;
import com.erp.mbg.model.UserExample;
import com.erp.mbg.model.UserLoginLog;
import com.erp.security.util.JwtTokenUtil;
import com.erp.service.UserCacheService;
import com.erp.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes;

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
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRelationDao userRoleRelationDao;
    @Autowired
    private UserCacheService userCacheService;
    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public User getUserByUsername(String username) {
        User user = userCacheService.getUser(username);
        if (user!=null) return  user;
        UserExample userExample= new UserExample();

        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users!=null && users.size()>0){
            user = users.get(0);
            userCacheService.setUser(user);
            return user;
        }
        return null;
    }

    @Override
    public User register(UserParam userParam) {
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        user.setCreateTime(new Date());
        user.setStatus(1);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()>0){
            return null;
        }
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return user;
    }

    @Override
    public String login(String username, String password) {
        String token=null;
        UserDetails userDetails = loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())){
            Asserts.fail("密码不正确");
        }
        if (!userDetails.isEnabled()){
            Asserts.fail("用户已被禁用");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        token = jwtTokenUtil.generateToken(userDetails);
        updateLoginTimeByUsername(username);
        insertLog(username);
        return token;
    }
    private void insertLog(String username){
        User user = getUserByUsername(username);
        if (user==null) return;
        UserLoginLog userLoginLog = new UserLoginLog();
        userLoginLog.setUserId(user.getId());
        userLoginLog.setCreateTime(new Date());
        ServletRequestAttributes Attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Attributes.getRequest();
        userLoginLog.setIp(request.getRemoteAddr());

        userLoginLogMapper.insert(userLoginLog);

    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = getUserByUsername(username);
        if (user!=null){
            List<Resource> resources = getResourceList(user.getId());
            return new UserDetail(user, resources);
        }
        throw new UsernameNotFoundException("用户名或者密码错误");
    }

    @Override
    public List<Resource> getResourceList(Long userId) {
        List<Resource> resources = userCacheService.getResourceList(userId);
        if (CollUtil.isNotEmpty(resources)){
            return resources;
        }
        resources = userRoleRelationDao.getResourceList(userId);
        if (CollUtil.isNotEmpty(resources)){
            userCacheService.setResourceList(userId, resources);
        }
        return resources;
    }


    @Override
    public User getItem(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id,User user) {
        user.setId(id);
        User rawUser = userMapper.selectByPrimaryKey(id);
        if (rawUser.getPassword().equals(user.getPassword())){
            user.setPassword(null);
        }else{
            if (StrUtil.isEmpty(user.getPassword())){
                user.setPassword(null);
            }else{
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
        }
        int count = userMapper.updateByPrimaryKeySelective(user);
        userCacheService.delUser(id);
        return count;
    }

    @Override
    public int updateLoginTimeByUsername(String username) {
        User user = getUserByUsername(username);
        user.setLoginTime(new Date());
        int count = userMapper.updateByPrimaryKeySelective(user);
        return count;
    }

}
