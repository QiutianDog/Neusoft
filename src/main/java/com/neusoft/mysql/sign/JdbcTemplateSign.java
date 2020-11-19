package com.neusoft.mysql.sign;

import com.neusoft.mysql.druid.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JdbcTemplateSign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 由键盘输入账号和密码
        System.out.printf("username:");
        String username = sc.next();

        System.out.printf("password:");
        String password = sc.next();

        // 登录
        boolean b = new JdbcTemplateSign().login(username, password);
        System.out.println(b);
    }

    // 使用jdbctemplate来完成登录
    public boolean login(String username, String password) {
        // 获取JdbcTemplate
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

        // 登录查询
        String sql = "select * from user where username = ? and password = ?";

        List<Map<String, Object>> maps = template.queryForList(sql, username, password);

        if (maps.size() == 1) {
            return true;
        }
        return false;
    }

}
