package mysql.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

// JDBC的工具类
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            // 获取数据
            Properties prop = new Properties();

            // 获取src路径下的文件的方式ClassLoader
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();

            prop.load(new FileReader(path));
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

            // 注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接 通过配置文件来解决
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    // 释放资源 DML
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

    // 释放资源
    public static void close(ResultSet resultSet, Statement stmt, Connection conn) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(stmt, conn);
    }

}
