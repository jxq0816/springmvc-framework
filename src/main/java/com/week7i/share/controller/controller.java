package com.week7i.share.controller;

/**
 * Created by boxiaotong on 2017/2/9.
 */

import com.week7i.share.service.SystemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boxiaotong on 2017/2/9.
 */
@Controller
@RequestMapping("user")
public class controller {
    @Autowired
    private SystemService service;

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "back")
    @ResponseBody
    public Map fun(){
        Map map=new HashMap();
        String password=service.login("admin");
        map.put("password",password);
        return map;
    }
    @RequestMapping(value = {"login",""},method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = {"login"},method= RequestMethod.POST)
    public String loginSubmit(String username,String password,Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        System.out.println("DefaultController.login#token="+token);

        Subject currentUser = SecurityUtils.getSubject();

        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            System.out.println("user[" + username + "]do login checking");
            currentUser.login(token);
            System.out.println("user[" + username + "]authentication success");

        }catch(UnknownAccountException uae){
            System.out.println("user[" + username + "]UnknownAccountException");
            model.addAttribute("error_msg", "UnknownAccountException");
        }catch(IncorrectCredentialsException ice){
            System.out.println("user[" + username + "]IncorrectCredentialsException");
            model.addAttribute("error_msg", "IncorrectCredentialsException");
        }catch(LockedAccountException lae){
            System.out.println("user[" + username + "]LockedAccountException");
            model.addAttribute("error_msg", "LockedAccountException");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("user[" + username + "]ExcessiveAttemptsException");
            model.addAttribute("error_msg", "ExcessiveAttemptsException");
        }catch(AuthenticationException ae){
            //注意：这个必须放在后面，因为这个异常可以处理所有认证失败的情况
            model.addAttribute("error_msg", "authentication faild");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            System.out.println("user[" + username + "]authentication success");
            return "index";
        }
        token.clear();
        return "login";
    }
    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
}