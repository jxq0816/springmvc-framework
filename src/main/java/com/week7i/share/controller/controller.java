package com.week7i.share.controller;

/**
 * Created by boxiaotong on 2017/2/9.
 */

import com.week7i.share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boxiaotong on 2017/2/9.
 */
@Controller
@RequestMapping("/")
public class controller {
    @Autowired
    private UserService service;

    @RequestMapping(value = "json")
    @ResponseBody
    public Map fun(){
        Map map=new HashMap();
        String name=service.query("1");
        map.put("name",name);
        return map;
    }
    @RequestMapping(value = {"login",""})
    public String index(){
        return "login";
    }
}