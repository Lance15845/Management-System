package com.wlh.coronavirus.controller;

import com.wlh.coronavirus.entity.IndexInfo;
import com.wlh.coronavirus.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.*;

@Controller
public class IndexController {

    @Resource
    PatientService patientService;
    @Resource
    TouchService touchService;
    @Resource
    CureService cureService;
    @Resource
    DeadService deadService;


    @RequestMapping(value = "/indexpage",produces="application/json;charset=UTF-8")
    public String index(Model model){
        //查找数量
        try{
            int pN = patientService.number();
            int pCN= patientService.currentNumber();
            int cN=cureService.number();
            int dN=deadService.number();
            int tN=touchService.number();
            int tCN=touchService.currentNumber();
            //计算百分比
            double cR=(double)Math.round(((double) cN / (double) pN)*100);
            double dR=(double)Math.round(((double) dN / (double) pN)*100);
            //放入indexInfo中
            IndexInfo indexInfo=new IndexInfo().setCureNumber(cN).
                    setCureRate(cR).setCurrentPatientNumber(pCN).setCurrentTouchNumber(tCN).
                    setDeadNumber(dN).setSumTouchNumber(tN).setDeadRate(dR).setSumPatientNumber(pN);
            patientDatas(indexInfo);
            model.addAttribute("indexInfo",indexInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }
    public void patientDatas(IndexInfo indexInfo){
        List dates=new ArrayList();
        List patientNums=new ArrayList();
        List curetNums=new ArrayList();
        for (int i=4;i>=0;i--){
            Date date= new Date(System.currentTimeMillis()-(i*86400000));
            dates.add(date.getTime());
            patientNums.add(patientService.beforeDay(date));
            curetNums.add(cureService.beforeDay(date));
        }
        indexInfo.setDates(dates).setPatientNums(patientNums).setCureNums(curetNums);
    }

}

