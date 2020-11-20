package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.obj.Food;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FoodDaoImpl implements FoodDao {

    private JdbcTemplate template;

    public FoodDaoImpl() {
        template = new JdbcTemplate(DruidUtils.getDataSource());
    }

    @Override
    public List<Food> listFood() {
        String sql = "select * from food";
        return template.query(sql, new BeanPropertyRowMapper<>(Food.class));
    }
}
