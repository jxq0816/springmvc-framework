package com.jxq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String query(String id) {
        String name;
        try{
            Map rs=jdbcTemplate.queryForMap("select name from sys_user where id='"+id+"'");
            name= (String) rs.get("name");
        }catch (Exception e) {
            throw e;
        }
        return name;
    }
}