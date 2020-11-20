package com.neusoft.elm;

import com.neusoft.elm.obj.Admin;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

// 饿了么的控制台版 JDBC 管理系统
public class ElmAdminEntry {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("---------饿了么后台管理系统---------");
        System.out.println("--------------------------------");

        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();

        if (admin != null) {
            System.out.println("Login successful!");
            BusinessView businessView = new BusinessViewImpl();


            while (true) {
                outputMessage();
                String menu = sc.next();
                switch (menu){
                    case "1":
                        businessView.listBusiness();
                        break;
                    case "5":
                        return;
                }
            }
        } else {
            System.out.println("Login error!");
        }
    }

    public static void outputMessage() {
        System.out.println("1.查看所有商家");
        System.out.println("2.搜索商家");
        System.out.println("3.新建商家");
        System.out.println("4.删除商家");
        System.out.println("5.退出系统");
        System.out.printf(">");
    }

}
