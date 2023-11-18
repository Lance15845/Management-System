package com.wlh.coronavirus.controller;


import com.github.pagehelper.PageInfo;
import com.wlh.coronavirus.entity.*;
import com.wlh.coronavirus.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import java.sql.Date;

@Controller
public class PatientController {
    @Resource
    PatientService service;
    @Resource
    BaseService baseService;
    @Resource
    CureService cureService;
    @Resource
    DeadService deadService;

    //查看现存确诊病人
    @RequestMapping(value = "/patient/list",method = RequestMethod.GET)
    public String list(Model model,@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Patient> patients = service.findAll(page,size);
        PageInfo<Patient> pageInfo=new PageInfo(patients);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("patientList", patients);
        return "patientList";
    }

    //跳转确诊病人转化治愈添加页面
    @RequestMapping(value="/patient/toCure/{id}",method=RequestMethod.GET)
    public String toCure(Model model, @PathVariable("id")int id)
    {
        model.addAttribute("baseId",id);
        return "patientToCure";
    }

    //确诊病人转化治愈
    @RequestMapping(value="/patient/addCure",method=RequestMethod.POST)
    public String addCure(@RequestParam("baseId")int baseId,@RequestParam("dischargeDate") Date dischargeDate,@RequestParam("current") String current)
    {
        Cure cure=new Cure().setBaseId(baseId).setCurrent(current).setDischargeDate(dischargeDate);
        cureService.add(cure);
        return "redirect:/patient/list";
    }

    //跳转确诊病人转化死亡页面
    @RequestMapping(value="/patient/toDead/{id}",method=RequestMethod.GET)
    public String toDead(Model model,@PathVariable("id")int id)
    {
        model.addAttribute("baseId",id);
        return "patientToDead";
    }


    //跳转添加页面
    @RequestMapping(value = "/patient/toAdd")
    public String toAdd(){
        return "patientAdd";
    }

    //添加基础信息
    @RequestMapping(value="/patient/addBase",method=RequestMethod.POST)
    public String addBase(@RequestParam("name")String name, @RequestParam("idCard")String idCard,
                          @RequestParam("gender")char gender, @RequestParam("address")String address,
                          @RequestParam("age")int age, @RequestParam("phone")String phone,
                          Model model){
        Base base = new Base();
        System.out.println(gender);;
        base.setName(name).setAddress(address).setAge(age).setGender(gender).setIdCard(idCard).setPhone(new BigInteger(phone));
        baseService.add(base);
        Base b2= baseService.findByIdCard(idCard);
        int id = b2.getId();
        model.addAttribute("baseId",id);
        return "patientAdd2";
    }

    //添加病患信息
    @RequestMapping(value="/patient/addPatient",method=RequestMethod.POST)
    public String addPatient(@RequestParam("baseId")int baseId, @RequestParam("infectionSource")String infectionSource,
                             @RequestParam("onsetDate") Date onsetDate, @RequestParam("symptoms")String symptoms,
                             @RequestParam("hospital")String hospital, @RequestParam("critical")char critical,
                             @RequestParam("note")String note){

        Patient patient=new Patient().setBaseId(baseId).setCritical(critical).setHospital(hospital)
                .setInfectionSource(infectionSource).setSymptoms(symptoms).setOnsetDate(onsetDate).setNote(note);
        service.add(patient);
        return "redirect:/patient/list";
    }

    //病人转化死亡
    @RequestMapping(value="/patient/addDead",method=RequestMethod.POST)
    public String addDead(@RequestParam("baseId")int baseId,@RequestParam("deadTime") Date deadTime)
    {
        Dead dead=new Dead().setDeadTime(deadTime).setBaseId(baseId);
        deadService.add(dead);
        return "redirect:/patient/list";
    }
    //更新病人信息
    @RequestMapping(value="/patient/updatePatient",method=RequestMethod.POST)
    public String update(@RequestParam("baseId")int baseId, @RequestParam("infectionSource")String infectionSource,
                         @RequestParam("onsetDate") Date onsetDate, @RequestParam("symptoms")String symptoms,
                         @RequestParam("hospital")String hospital, @RequestParam("critical")char critical,
                         @RequestParam("note")String note)
    {     Patient patient=new Patient().setBaseId(baseId).setCritical(critical).setHospital(hospital)
            .setInfectionSource(infectionSource).setSymptoms(symptoms).setOnsetDate(onsetDate).setNote(note);
        service.update(patient);
        return "redirect:/patient/info/"+patient.getBaseId();

    }
    //跳转患者详情页面
    @RequestMapping(value="/patient/info/{id}",method= RequestMethod.GET)
    public String info(Model model,@PathVariable("id")int id)
    {
        Patient patient = service.findById(id);
        model.addAttribute("patient",patient);
        return "patientInfo";
    }

    //跳转检测添加页面
    @RequestMapping(value="/patient/toAddTest/{id}",method=RequestMethod.GET)
    public String toTest(Model model,@PathVariable("id")int id)
    {
        model.addAttribute("baseId",id);
        return "patientAddTest";
    }


}