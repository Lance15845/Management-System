package com.wlh.coronavirus.service.iml;


import com.wlh.coronavirus.dao.BaseDao;
import com.wlh.coronavirus.entity.Base;
import com.wlh.coronavirus.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BaseServiceImp implements BaseService {
    @Resource
    BaseDao dao;

    @Override
    public List<Base> findAll() {
        return null;
    }

    @Override
    public Base findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Base base) {
        dao.add(base);
    }

    @Override
    public Base findByIdCard(String idCard) {
        return dao.findByIdCard(idCard);
    }

    @Override
    public void update(Base base) {
        dao.update(base);
    }
}