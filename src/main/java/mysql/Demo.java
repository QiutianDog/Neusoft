package mysql;

import java.sql.*;

public class Demo {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.登录
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");

            // 3.创建执行sql语句的对象statement (新建查询)
            stmt = conn.createStatement();

//            // 4.随便写一个语句
//            String sql = "insert into student (id,name,age,gender) values ('188111541215','Alice',3,'f')";
//
//            // 5.执行命令
//            int result = stmt.executeUpdate(sql);

            String sql = "select * from student";

            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Date date = resultSet.getDate(5);

                System.out.printf("%s, %-8s, %-2d, %s\n",id,name,age,date.toString());
            }


//            System.out.println(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
          try {
              if (conn != null) {
                conn.close();
              }

              if (stmt != null) {
                  stmt.close();
              }

              if (resultSet != null) {
                  resultSet.close();
              }
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
        }

    }

}
