package com.jxq;

/**
 * Created by boxiaotong on 2017/2/9.
 */

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
    @RequestMapping(value = "json")
    @ResponseBody
    public Map fun(){
        Map map=new HashMap();
        map.put("name","姜兴琪");
        return map;
    }
    @RequestMapping(value = {"login",""})
    public String index(){
        return "login";
    }
}