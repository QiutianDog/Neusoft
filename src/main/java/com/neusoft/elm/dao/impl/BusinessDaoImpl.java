package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.obj.Business;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BusinessDaoImpl implements BusinessDao {

    private JdbcTemplate template;

    public BusinessDaoImpl() {
        template = new JdbcTemplate(DruidUtils.getDataSource());
    }

    @Override
    public List<Business> listBusiness() {
        String sql = "select * from business";
        return template.query(sql, new BeanPropertyRowMapper<>(Business.class));
    }

    @Override
    public Integer saveBusiness(String businessName, String password) {
        String sql = "insert into business(businessName, password) values(?, ?)";
        template.update(sql, businessName, password);

        // 获取自增长的Id
        Map<String, Object> map = template.queryForMap("select * from business where businessName = ?", businessName);
        Object businessId = map.get("businessId");
        return (Integer) businessId;
    }


    @Override
    public int removeBusiness(Integer businessId) {
        String sql = "delete from business where businessId = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DruidUtils.getConnect();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            int i = pstmt.executeUpdate();

            conn.commit();
            return i;
        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(pstmt, conn);
        }

        return -1;
    }

    @Override
    public int updateBusiness(Business business) {
        return 0;
    }

    @Override
    public Business selectBusinessById(Integer businessId) {
        String sql = "select * from business where businessId = ?";
        List<Business> list = template.query(sql, new BeanPropertyRowMapper<>(Business.class), businessId);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    @Test
    public void test() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        Business business = dao.selectBusinessById(10005);
        System.out.println(business);
    }
}
