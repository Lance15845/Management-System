package com.wlh.coronavirus.service;

import com.wlh.coronavirus.entity.Patient;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;


public interface PatientService {
    //查找所有病患
    public List<Patient> findAll(int size,int page);
    //添加病患
    public void add(Patient patient);
    //更新病患信息
    public void update(Patient patient);
    //根据id查找病患
    public Patient findById(int  id);
    //查找病患总人数
    public int number();
    //查找现存病患人数
    public int currentNumber();
    //查找当日之前的累计
    public int beforeDay(Date date);

}