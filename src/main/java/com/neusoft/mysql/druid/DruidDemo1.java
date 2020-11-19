package com.neusoft.mysql.druid;

import com.neusoft.mysql.druid.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 测试DruidUtils对象
public class DruidDemo1 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 获取连接
            conn = DruidUtils.getConnect();

            String sql = "select * from user";

            // 获取声明
            pstmt = conn.prepareStatement(sql);

            // 执行
            rs = pstmt.executeQuery();

            // 查看结果
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.printf("%s, %s\n", username, password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 归还对象
            DruidUtils.close(rs, pstmt, conn);
        }
    }

}
