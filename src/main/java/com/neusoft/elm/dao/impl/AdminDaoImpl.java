package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.obj.Admin;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template;

    public AdminDaoImpl() {
        template = new JdbcTemplate(DruidUtils.getDataSource());
    }

    @Override
    public List<Admin> listAdmin() {
        String sql = "select * from admin";
        return template.query(sql, new BeanPropertyRowMapper<>(Admin.class));
    }

}
