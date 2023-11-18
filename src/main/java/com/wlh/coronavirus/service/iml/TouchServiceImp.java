package com.wlh.coronavirus.service.iml;


import com.github.pagehelper.PageHelper;
import com.wlh.coronavirus.dao.TouchDao;
import com.wlh.coronavirus.entity.Touch;
import com.wlh.coronavirus.service.TouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TouchServiceImp implements TouchService {
    @Resource
    TouchDao dao;


    @Override
    public List<Touch> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Touch touch) {
        dao.add(touch);
    }

    @Override
    public Touch findById(int baseId) {
        return dao.findById(baseId);
    }

    @Override
    public void toSafe(int baseId) {
        dao.toSafe(baseId);
    }

    @Override
    public Integer number() {
        Integer i = dao.number();
        if (i==null){
            return 0;
        }
        return i;
    }

    @Override
    public Integer currentNumber() {
        Integer i = dao.currentNumber();
        if (i==null){
            return 0;
        }
        return i;
    }
}
