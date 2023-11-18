package com.wlh.coronavirus.service.iml;


import com.github.pagehelper.PageHelper;
import com.wlh.coronavirus.dao.UserDao;
import com.wlh.coronavirus.entity.User;
import com.wlh.coronavirus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    UserDao dao;

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public List<User> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


}
