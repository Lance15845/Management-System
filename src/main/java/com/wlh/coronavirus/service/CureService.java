package com.wlh.coronavirus.service;

import com.wlh.coronavirus.entity.Cure;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;


public interface CureService {

    public void add(Cure cure);
    public List<Cure> findAll(int page,int size);
    public Cure get(int id);
    public int number();
    public int beforeDay(Date date);


}
