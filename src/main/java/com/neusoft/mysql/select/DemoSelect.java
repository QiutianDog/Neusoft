package com.neusoft.mysql.select;

import com.neusoft.mysql.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoSelect {

    // 查询所有对象
    public static List<Student> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:com.neusoft.mysql:///school", "root", "root");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("select * from student");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Date insert_time = resultSet.getDate("insert_time");

                list.add(new Student(id, name, age, gender, insert_time));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

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
        return list;
    }

    // 使用JDBCUtils简化的查询所有
    public static List<Student> simpleFindAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 获取声明
            stmt = conn.createStatement();

            // 查询
            resultSet = stmt.executeQuery("select * from student");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Date insert_time = resultSet.getDate("insert_time");

                list.add(new Student(id, name, age, gender, insert_time));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, stmt, conn);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = simpleFindAll();

        for (Student student : students) {
            System.out.println(student);
        }

    }

}
