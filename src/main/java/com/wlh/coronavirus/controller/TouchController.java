package com.wlh.coronavirus.controller;


import com.github.pagehelper.PageInfo;
import com.wlh.coronavirus.entity.Touch;
import com.wlh.coronavirus.service.PatientService;
import com.wlh.coronavirus.service.TouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.sql.Date;

@Controller
public class TouchController {
    @Resource
    TouchService service;

    //查看现存密切接触者
    @RequestMapping(value = "/touch/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "25") int size){
        List<Touch> touches = service.findAll(page, size);
        PageInfo pageInfo=new PageInfo(touches);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("touchList",touches);
        return "touchList";

    }

    //跳转密切接触者转化确诊页面
    @RequestMapping(value="/touch/toPatient/{baseId}",method=RequestMethod.GET)
    public String toPatientPage(Model model, @PathVariable("baseId")int baseId)
    {
        service.toSafe(baseId);
        model.addAttribute("baseId",baseId);
        return "patientAdd2";
    }
    //隔离完成
    @RequestMapping(value = "/touch/toSafe/{baseId}",method = RequestMethod.GET)
    public String toSafe( @PathVariable("baseId")int baseId){

        service.toSafe(baseId);

        return "redirect:/touch/list";

    }

    //跳转密切接触者详情页面
    @RequestMapping(value="/touch/info/{id}",method= RequestMethod.GET)
    public String info(Model model,@PathVariable("id")int id)
    {
        Touch touch = service.findById(id);
        System.out.println(touch);
        model.addAttribute("touch",touch);
        return "touchInfo";
    }

    //添加密切
    @RequestMapping(value="/touch/add",method=RequestMethod.POST)
    public String addPatient(@RequestParam("baseId")int baseId, @RequestParam("comeFrom")String comeFrom,
                             @RequestParam("startDate") Date startDate, @RequestParam("isoAddress")String isoAddress,
                             @RequestParam("finished")char finished){

        Touch touch=new Touch().setBaseId(baseId).setComeFrom(comeFrom).setFinished(finished).setIsoAddress(isoAddress).setStartDate(startDate);
        service.add(touch);
        return "redirect:/touch/list";
    }

    //跳转添加页面
    @RequestMapping(value = "/touch/toAdd")
    public String toAdd(){
        return "touchAdd";
    }
}
