package com.wlh.coronavirus.service;

import com.wlh.coronavirus.entity.User;

import java.util.List;

public interface UserService {

    //添加用户
    public void addUser(User user);
    //删除用户
    public void deleteUser(int id);
    //查找所有用户
    public List<User> findAll(int page, int size);

}
