package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.obj.Admin;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements AdminDao {

    private JdbcTemplate template;

    public AdminDaoImpl() {
        template = new JdbcTemplate(DruidUtils.getDataSource());
    }


    @Override
    public Admin getAdminByNameAndPassword(String adminName, String password) {
        String sql = "select * from admin where adminName = ? and password = ?";
        List<Admin> list = template.query(sql, new BeanPropertyRowMapper<>(Admin.class), adminName, password);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
