package com.neusoft.elm;

import com.neusoft.elm.obj.Admin;
import com.neusoft.elm.view.AdminView;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.AdminViewImpl;
import com.neusoft.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * 饿了么的控制台版 JDBC 管理系统
 * @author QiutianDog
  */
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
            int menu = 0;
            int exit = 6;

            while (menu != exit) {
                outputMessage();
                menu = getMenu(sc);
                switch (menu){
                    case 1:
                        businessView.listBusiness();
                        break;
                    case 2:
                        businessView.selectBusinessById();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.updateBusiness();
                        break;
                    case 5:
                        businessView.removeBusiness();
                        break;
                    case 6:
                        System.out.println("欢迎再来!");
                        break;
                    default:
                        System.out.println("没有这个选项!");
                }
            }
        } else {
            System.out.println("Login error!");
        }
    }

    public static void outputMessage() {
        System.out.println("*******************");
        System.out.println("*  1.查看所有的商家  *");
        System.out.println("*  2.搜索商家       *");
        System.out.println("*  3.新建商家       *");
        System.out.println("*  4.修改商家       *");
        System.out.println("*  5.删除商家       *");
        System.out.println("*  6.退出系统       *");
        System.out.println("*******************");
        System.out.print(">");
    }

    public static Integer getMenu(Scanner sc) {
        while (true) {
            String s = sc.next();
            if (s.length() == 1) {
                if (s.charAt(0) >= '1' && s.charAt(0) <= '6') {
                    return s.charAt(0) - '0';
                }
            }
        }
    }

}
