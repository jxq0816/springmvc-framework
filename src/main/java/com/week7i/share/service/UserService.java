package com.week7i.share.service;

import com.week7i.share.dao.UserDao;
import com.week7i.share.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String query(String id){
        String rs;
        Object name=CacheUtils.get(id);
        if(name!=null){
            rs=(String)name;
        }else{
            Map param=new HashMap<>();
            param.put("id",id);
            rs=userDao.query(param);
            CacheUtils.put(id,rs);
        }
        return rs;
    }
}
