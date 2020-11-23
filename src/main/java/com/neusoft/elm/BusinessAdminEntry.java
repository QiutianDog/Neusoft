package com.neusoft.elm;

import com.neusoft.elm.obj.Business;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * 商家登录平台
 * @author QiutianDog
 */
public class BusinessAdminEntry {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        // 登录账号
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("---------饿了么商家管理系统---------");
        System.out.println("--------------------------------");

        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();

        if (business != null) {
            // 登录成功
            System.out.println("Login successful!");
            System.out.println("welcome back " + business.getBusinessName() + " !");


            int menu = 0;
            int exit = 5;

            while (menu != exit) {
                outputMessage();
                menu = getMenu(sc);
                switch (menu) {
                    case 1:
                        // 查看商家信息
                        businessView.outputBusinessById(business.getBusinessId());
                        break;
                    case 2:
                        // 修改商家信息
                        businessView.updateBusiness(business.getBusinessId());
                        break;
                    case 3:
                        // 修改密码
                        businessView.updateBusinessPassword(business.getBusinessId());
                        break;
                    case 4:
                        businessView.controlFood(business.getBusinessId());
                        // 所属商品管理
                        break;
                    case 5:
                        // 退出系统
                        System.out.println("exit OK!");
                        break;
                    default:
                }
            }
        } else {
            System.out.println("Login error!");
        }
    }

    public static void outputMessage() {
        System.out.println("********************");
        System.out.println("*  1.查看商家信息     *");
        System.out.println("*  2.修改商家信息     *");
        System.out.println("*  3.修改密码        *");
        System.out.println("*  4.所属商品管理     *");
        System.out.println("*  5.退出系统        *");
        System.out.println("********************");
        System.out.print(">");
    }

    public static Integer getMenu(Scanner sc) {
        while (true) {
            String s = sc.next();
            if (s.length() == 1) {
                if (s.charAt(0) >= '1' && s.charAt(0) <= '5') {
                    return s.charAt(0) - '0';
                }
            }
        }
    }
}
