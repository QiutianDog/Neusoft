package mysql.select;

import mysql.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoSelect2 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<Employee> list = new ArrayList<>();
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 获取声明
            stmt = conn.createStatement();

            // 查询
            ResultSet set = stmt.executeQuery("select * from emp");
            while (set.next()) {
                Object empno = set.getObject("EMPNO");
                Object ename = set.getObject("ENAME");
                Object job = set.getObject("JOB");
                Object mgr = set.getObject("MGR");
                Object hiredate = set.getObject("HIREDATE");
                Object sal = set.getObject("SAL");
                Object comm = set.getObject("COMM");
                Object deptno = set.getObject("DEPTNO");

                list.add(new Employee((Integer) empno
                        , (String) ename
                        , (String) job
                        , (Integer) mgr
                        , (Date) hiredate
                        , (Integer) sal
                        , (Integer) comm
                        , (Integer) deptno));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, stmt, conn);
        }

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

}
