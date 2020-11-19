package com.neusoft.jdbcTemplate;

import com.neusoft.mysql.druid.utils.DruidUtils;
import com.neusoft.mysql.select.Employee;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

// 测试JDBCTemplate
public class DemojdbcTemplate {

    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void test01() {
        // 查询id为1的用户，封装为map集合 结果只能是一个
        String sql = "select * from user where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }

    @Test
    public void test02() {
        // 查询所有记录 封装成List集合 每一个记录封装成一个map再封装到list里面
        String sql = "select * from emp";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test03() {
        // 查询所有记录 先封装成emp对象，再封装到list集合里面
        String sql = "select * from emp";
        List<Employee> list = template.query(sql, new BeanPropertyRowMapper<>(Employee.class));

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test04() {
        // 查询记录总数
        String sql = "select count(*) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }

}
