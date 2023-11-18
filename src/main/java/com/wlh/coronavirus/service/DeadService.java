package com.wlh.coronavirus.service;

import com.wlh.coronavirus.dao.DeadDao;
import com.wlh.coronavirus.entity.Cure;
import com.wlh.coronavirus.entity.Dead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeadService {
    public void add(Dead dead);
    public List<Dead> findAll(int page,int size);
    public Dead get(int id);
    public int number();

}