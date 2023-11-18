package com.wlh.coronavirus.service.iml;


import com.github.pagehelper.PageHelper;
import com.wlh.coronavirus.dao.CureDao;
import com.wlh.coronavirus.entity.Cure;
import com.wlh.coronavirus.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class CureServiceImp implements CureService {
    @Resource
    CureDao dao;
    @Override
    public void add(Cure cure) {
        dao.add(cure);
    }

    @Override
    public List<Cure> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


    @Override
    public Cure get(int id) {
        Cure cure = dao.findById(id);
        return cure;
    }

    @Override
    public int number() {
        return dao.number();
    }


    @Override
    public int beforeDay(Date date) {
        return dao.beforeDay(date);
    }


}
