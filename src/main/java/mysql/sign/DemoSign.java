package mysql.sign;

import mysql.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
    通过键盘输入的用户名和密码判断用户是否登录成功（不是登录数据库）
 */
public class DemoSign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 由键盘输入账号和密码
        System.out.printf("username:");
        String username = sc.next();

        System.out.printf("password:");
        String password = sc.next();

        // 登录
        boolean b = new DemoSign().safeLogin(username, password);
        /*boolean b = new DemoSign().login(username, password);*/
        System.out.println(b);
    }

    // 安全登录 解决sql注入的问题
    public boolean safeLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // 连接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet set = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            set = pstmt.executeQuery();
            return set.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(set, pstmt, conn);
        }

        return false;
    }

    // 登录方法 不安全的登录方式
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // 连接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt = null;
        ResultSet set = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            // 定义sql (这里会产生sql注入的安全性问题)
            String sql = "SELECT * FROM user WHERE username = '" +
                    username + "' and password = '" +
                    password + "'";
            set = stmt.executeQuery(sql);
            return set.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(set, stmt, conn);
        }

        return false;
    }

}
