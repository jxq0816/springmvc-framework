package com.jxq.service;

import com.jxq.dao.UserDao;
import com.jxq.util.CacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            rs=userDao.query(id);
            CacheUtils.put(id,rs);
        }
        return rs;
    }
}
