package com.week7i.share.service;

import com.week7i.share.dao.UserDao;
import com.week7i.share.util.CacheUtils;
import com.week7i.share.util.SpringContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class SystemService {

    private UserDao userDao= SpringContextHolder.getBean(UserDao.class);

    public String login(String username){
        String rs;
        Object password=CacheUtils.get(username);
        if(password!=null){
            rs=(String)password;
        }else{
            Map param=new HashMap<>();
            param.put("username",username);
            rs=userDao.login(param);
            CacheUtils.put(username,rs);
        }
        return rs;
    }
}
