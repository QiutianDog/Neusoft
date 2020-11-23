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

/**
 * 商店接口的实现 用来管理商家的相关设置
 * @author QiutianDog
 */
public class BusinessDaoImpl implements BusinessDao {

    private final JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public Business getBusinessByIdAndPassword(Integer businessId, String password) {
        String sql = "select * from business where businessId = ? and password = ?";
        List<Business> list = template.query(sql, new BeanPropertyRowMapper<>(Business.class), businessId, password);
        if (list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Business getBusinessById(Integer businessId) {
        String sql = "select * from business where businessId = ?";
        List<Business> list = template.query(sql, new BeanPropertyRowMapper<>(Business.class), businessId);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateBusiness(Business business) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            int i = -1;
            conn = DruidUtils.getConnect();
            conn.setAutoCommit(false);

            if (business.getBusinessName() != null) {
                pstmt = conn.prepareStatement("update business set businessName = ? where businessId = ?");
                pstmt.setString(1, business.getBusinessName());
                pstmt.setInt(2, business.getBusinessId());
                i = pstmt.executeUpdate();
            }

            if (business.getBusinessAddress() != null) {
                pstmt = conn.prepareStatement("update business set businessAddress = ? where businessId = ?");
                pstmt.setString(1, business.getBusinessAddress());
                pstmt.setInt(2, business.getBusinessId());
                i = pstmt.executeUpdate();
            }
            if (business.getBusinessExplain() != null) {
                pstmt = conn.prepareStatement("update business set businessExplain = ? where businessId = ?");
                pstmt.setString(1, business.getBusinessExplain());
                pstmt.setInt(2, business.getBusinessId());
                i = pstmt.executeUpdate();
            }
            if (business.getStarPrice() != null) {
                pstmt = conn.prepareStatement("update business set starPrice = ? where businessId = ?");
                pstmt.setDouble(1, business.getStarPrice());
                pstmt.setInt(2, business.getBusinessId());
                i = pstmt.executeUpdate();
            }
            if (business.getStarPrice() != null) {
                pstmt = conn.prepareStatement("update business set deliveryPrice = ? where businessId = ?");
                pstmt.setDouble(1, business.getDeliveryPrice());
                pstmt.setInt(2, business.getBusinessId());
                i = pstmt.executeUpdate();
            }

            conn.commit();
            return i;
        } catch (SQLException throwables) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
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
    public int updateBusinessPassword(Integer businessId, String newPassword) {
        String sql = "update business set password = ? where businessId = ?";
        return template.update(sql, newPassword, businessId);
    }

}