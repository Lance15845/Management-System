package com.wlh.coronavirus.controller;


import com.github.pagehelper.PageInfo;
import com.wlh.coronavirus.entity.Cure;
import com.wlh.coronavirus.entity.Dead;
import com.wlh.coronavirus.entity.User;
import com.wlh.coronavirus.service.CureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CureController {
    @Resource
    CureService service;
    //所有治愈者
    @RequestMapping(value = "cure/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25")int size){
        List<Cure> cures = service.findAll(page,size);
        PageInfo<Cure> pageInfo=new PageInfo(cures);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("cureList", cures);
        return "cureList";
    }

    //根据id查找治愈者
    @RequestMapping(value = "cure/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id, Model model){
        Cure cure = service.get(id);
        model.addAttribute("cure",cure);
        return "cureInfo";
    }


}
