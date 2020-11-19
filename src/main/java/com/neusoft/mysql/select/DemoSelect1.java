package com.neusoft.mysql.select;

import com.neusoft.mysql.utils.JDBCUtils;

import java.sql.*;

// 查询EMP表
public class DemoSelect1 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 获取声明
            stmt = conn.createStatement();

            // 查询
            ResultSet set = stmt.executeQuery("select * from emp");
            while (set.next()) {
                Integer empno = set.getInt("EMPNO");
                String ename = set.getString("ENAME");
                String job = set.getString("JOB");
                Object mgr = set.getObject("MGR");
                Date hiredate = set.getDate("HIREDATE");
                Integer sal = set.getInt("SAL");
                Object comm = set.getObject("COMM");
                Integer deptno = set.getInt("DEPTNO");

                System.out.printf("%-10d,%-10s,%-10s,%-10d,%-10s,%-10d,%-10d,%-10d\n",
                        empno, ename, job, mgr, hiredate, sal, comm, deptno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, stmt, conn);
        }
    }

}
