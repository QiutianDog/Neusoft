package com.neusoft.elm.dao.impl;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.obj.Food;
import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 食物接口的实现
 * @author QiutianDog
 */
public class FoodDaoImpl implements FoodDao {

    private final JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public List<Food> listFood() {
        String sql = "select * from food";
        return template.query(sql, new BeanPropertyRowMapper<>(Food.class));
    }

    @Override
    public Integer saveFood(Food food) {
        String sql = "insert into food values(null, ?, ?, ?, ?)";
        String foodName = food.getFoodName();
        String foodExplain = food.getFoodExplain();
        Double foodPrice = food.getFoodPrice();
        Integer businessId = food.getBusinessId();
        int i = template.update(sql, foodName, foodExplain, foodPrice, businessId);
        if (i == 1) {
            // 查询新添加的
            Map<String, Object> map = template.queryForMap("select foodId from food where foodName = ?", foodName);
            Object foodId = map.get("foodId");
            return (Integer) foodId;
        } else {
            return null;
        }
    }

    @Override
    public int removeFood(Integer foodId) {
        String sql = "delete from food where foodId = ?";
        return template.update(sql, foodId);
    }

    @Override
    public int updateFood(Food food) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            int count = -1;
            conn = DruidUtils.getConnect();
            conn.setAutoCommit(false);

            if (food.getFoodName() != null) {
                pstmt = conn.prepareStatement("update food set foodName = ? where foodId = ?");
                pstmt.setString(1, food.getFoodName());
                pstmt.setInt(2, food.getFoodId());
                count = pstmt.executeUpdate();
            }

            if (food.getFoodExplain() != null) {
                pstmt = conn.prepareStatement("update food set foodExplain = ? where foodId = ?");
                pstmt.setString(1, food.getFoodExplain());
                pstmt.setInt(2, food.getFoodId());
                count = pstmt.executeUpdate();
            }
            if (food.getFoodPrice() != null) {
                pstmt = conn.prepareStatement("update food set foodPrice = ? where foodId = ?");
                pstmt.setDouble(1, food.getFoodPrice());
                pstmt.setInt(2, food.getFoodId());
                count = pstmt.executeUpdate();
            }
            if (food.getBusinessId() != null) {
                pstmt = conn.prepareStatement("update food set businessId = ? where foodId = ?");
                pstmt.setInt(1, food.getBusinessId());
                pstmt.setInt(2, food.getFoodId());
                count = pstmt.executeUpdate();
            }

            conn.commit();
            return count;
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
    public Food selectFoodById(Integer foodId) {
        String sql = "select * from food where foodId = ?";
        List<Food> list = template.query(sql, new BeanPropertyRowMapper<>(Food.class), foodId);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
