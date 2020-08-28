package com.erp.service;

import com.erp.mbg.model.User;

import java.util.List;

public interface UserService {
    List<User> listAllUser();

    int createUser(User User);

    int updateUser(Long id, User User);

    int deleteUser(Long id);

    List<User> listUser(int pageNum, int pageSize);

    User getUser(Long id);
}
