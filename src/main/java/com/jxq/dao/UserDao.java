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

    public String query() {

        String sql = "select count(*) from sys_user";
        try{
            Map rs=jdbcTemplate.queryForMap("select name from sys_user where id='1'");
            int n = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
            System.out.println(n);
        }catch (Exception e) {
            throw e;
        }
        return "";
    }
}