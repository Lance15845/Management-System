package com.wlh.coronavirus.service.iml;

import com.github.pagehelper.PageHelper;
import com.wlh.coronavirus.dao.DeadDao;
import com.wlh.coronavirus.entity.Dead;
import com.wlh.coronavirus.service.DeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DeadServiceImp implements DeadService {
    @Resource
    DeadDao dao;
    @Override
    public void add(Dead dead) {
        dao.add(dead);
    }

    @Override
    public List<Dead> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Dead get(int id) {
        return dao.findById(id);
    }

    @Override
    public int number() {
        return dao.number();
    }


}
