package com.jxq;

/**
 * Created by boxiaotong on 2017/2/9.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by boxiaotong on 2017/2/9.
 */
@Controller
@RequestMapping("control")
public class controller {
    @RequestMapping(value = "test")
    public String fun(){
        return "index";
    }

}