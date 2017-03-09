package com.jxq.service;

import com.jxq.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String query(){
        return userDao.query();
    }
}
