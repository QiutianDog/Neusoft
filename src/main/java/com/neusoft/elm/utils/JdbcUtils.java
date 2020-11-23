package com.neusoft.elm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author QiutianDog
 * @Date 2020/11/23
 */
public class JdbcUtils {
    private static DataSource ds;

    static {
        try {
            // 加载配置文件
            Properties prop = new Properties();
            prop.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接对象
    public static Connection getConnect() throws SQLException {
        return ds.getConnection();
    }

    // 获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    // 释放资源
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(stmt, conn);
    }
}
