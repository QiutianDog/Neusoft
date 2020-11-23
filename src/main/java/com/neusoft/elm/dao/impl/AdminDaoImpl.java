package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.obj.Admin;
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
 * 管理员接口的实现
 * @author QiutianDog
 */
public class AdminDaoImpl implements AdminDao {

    private final JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public Admin getAdminByNameAndPassword(String adminName, String password) {
        String sql = "select * from admin where adminName = ? and password = ?";
        List<Admin> list = template.query(sql, new BeanPropertyRowMapper<>(Admin.class), adminName, password);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Business> listBusiness() {
        String sql = "select * from business";
        return template.query(sql, new BeanPropertyRowMapper<>(Business.class));
    }

    @Override
    public Integer saveBusiness(String businessName, String password) {
        String sql = "insert into business(businessName, password) values(?, ?)";
        int i = template.update(sql, businessName, password);

        if (i == 1) {
            // 获取自增长的Id
            Map<String, Object> map = template.queryForMap("select * from business where businessName = ?", businessName);
            Object businessId = map.get("businessId");
            return (Integer) businessId;
        } else {
            return null;
        }
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
    public Business selectBusinessById(Integer businessId) {
        String sql = "select * from business where businessId = ?";
        List<Business> list = template.query(sql, new BeanPropertyRowMapper<>(Business.class), businessId);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
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
