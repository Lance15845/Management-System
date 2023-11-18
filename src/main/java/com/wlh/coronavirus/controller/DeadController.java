package com.wlh.coronavirus.controller;


import com.github.pagehelper.PageInfo;
import com.wlh.coronavirus.entity.Dead;
import com.wlh.coronavirus.entity.User;
import com.wlh.coronavirus.service.DeadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeadController {
    @Resource
    DeadService service;

    @RequestMapping(value = "dead/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Dead> deads = service.findAll( page, size);
        PageInfo<Dead> pageInfo = new PageInfo(deads, size);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("deadList",deads);
        return "deadList";
    }

    //添查看死亡详情
    @RequestMapping(value = "dead/info/{id}",method = RequestMethod.GET)
    public String info(@PathVariable("id")int id, Model model){
        Dead dead = service.get(id);
        model.addAttribute("dead",dead);
        return "deadInfo";
    }

}
