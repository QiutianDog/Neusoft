package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.obj.Business;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 商店接口的实现
 * @author QiutianDog
 */
public class BusinessDaoImpl implements BusinessDao {

    private final JdbcTemplate template;

    public BusinessDaoImpl() {
        template = new JdbcTemplate(DruidUtils.getDataSource());
    }

    @Override
    public Business getBusinessByIdAndPassword(Integer businessId, String password) {
        String sql = "select * from business where businessId = ? and password = ?";
        List<Business> list = template.query(sql, new BeanPropertyRowMapper<>(Business.class), businessId, password);
        if (list.size() == 1){
            return list.get(0);
        }
        return null;
    }

}