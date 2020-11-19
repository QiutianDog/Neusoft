package com.neusoft.mysql.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

// 测试druid 使用连接池工厂获取连接池对象
public class DruidDemo {

    public static void main(String[] args) {
        try {
            // 加载配置文件
            Properties prop = new Properties();
            InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(is);

            // 获取连接池连接对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

            // 获取连接
            Connection conn = dataSource.getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
