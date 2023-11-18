package com.wlh.coronavirus.service.iml;


import com.github.pagehelper.PageHelper;
import com.wlh.coronavirus.dao.PatientDao;
import com.wlh.coronavirus.entity.Patient;
import com.wlh.coronavirus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class PatientServiceImp implements PatientService {
    @Resource
    PatientDao dao;
    @Override
    public List<Patient> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Patient patient) {
        dao.add(patient);
    }

    @Override
    public void update(Patient patient) {
        dao.update(patient);
    }

    @Override
    public Patient findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int number() {

        return dao.number();
    }

    @Override
    public int currentNumber() {
        return dao.currentNumber();
    }


    @Override
    public int beforeDay(Date date) {
        return dao.beforeDay(date);
    }


}
