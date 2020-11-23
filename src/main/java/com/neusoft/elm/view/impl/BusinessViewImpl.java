package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.AdminDaoImpl;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.obj.Food;
import com.neusoft.elm.view.BusinessView;
import com.neusoft.elm.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author QiutianDog
 */
public class BusinessViewImpl implements BusinessView {

    private final BusinessDao businessDao = new BusinessDaoImpl();
    private final Scanner sc = new Scanner(System.in);


    @Override
    public Business login() {
        System.out.print("BusinessId:");
        Integer businessId = sc.nextInt();

        System.out.print("password:");
        String password = sc.next();
        return businessDao.getBusinessByIdAndPassword(businessId, password);
    }

    @Override
    public void outputBusinessById(Integer businessId) {
        Business business = businessDao.getBusinessById(businessId);
        System.out.println(business);
    }

    @Override
    public void updateBusiness(Integer businessId) {
        Business business = businessDao.getBusinessById(businessId);
        System.out.println("please input some information!");
        System.out.println("'null' or info");
        String change = "null";

        System.out.print("businessName:");
        String businessName = sc.next();
        if (!change.equals(businessName)) {
            business.setBusinessName(businessName);
        }

        System.out.print("businessAddress:");
        String businessAddress = sc.next();
        if (!change.equals(businessAddress)) {
            business.setBusinessAddress(businessAddress);
        }

        System.out.print("businessExplain:");
        String businessExplain = sc.next();
        if (!change.equals(businessExplain)) {
            business.setBusinessExplain(businessExplain);
        }

        System.out.print("starPrice:");
        String starPrice = sc.next();
        if (!change.equals(starPrice)) {
            business.setStarPrice(Double.valueOf(starPrice));
        }

        System.out.print("deliveryPrice:");
        String deliveryPrice = sc.next();
        if (!change.equals(deliveryPrice)) {
            business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        }

        int i = businessDao.updateBusiness(business);
        if (i == 1) {
            System.out.println("update business succeed!");
        } else {
            System.out.printf("update business have some problem, you changed %d lines\n", i);
        }
    }

    @Override
    public void updateBusinessPassword(Integer businessId) {
        System.out.print("old password:");
        String oldPassword = sc.next();

        if (oldPassword.equals(businessDao.getBusinessById(businessId).getPassword())) {
            System.out.print("new password:");
            String newPassword = sc.next();
            int i = businessDao.updateBusinessPassword(businessId, newPassword);
            if (i == 1) {
                System.out.println("update password succeed!");
            }
        } else {
            System.out.println("password is wrong!");
        }
    }

    @Override
    public void controlFood(Integer businessId) {
        int menu = 0;
        int exit = 6;
        FoodView foodView = new FoodViewImpl();
        while (exit != menu) {
            outputFoodMessage();
            menu = getMenu(sc);
            switch (menu) {
                case 1:
                    foodView.listFood(businessId);
                    break;
                case 2:
                    foodView.saveFood(businessId);
                    break;
                case 3:
                    foodView.removeFood(businessId);
                    break;
                case 4:
                    foodView.updateFood(businessId);
                    break;
                case 5:
                    foodView.selectFoodById(businessId);
                    break;
                case 6:
                    System.out.println("return Business!");
                    break;
                default:
            }
        }
    }

    public void outputFoodMessage() {
        System.out.println("+-----------------+");
        System.out.println("|   1.列出食品清单   |");
        System.out.println("|   2.添加食品      |");
        System.out.println("|   3.删除食品      |");
        System.out.println("|   4.修改食品信息   |");
        System.out.println("|   5.查询食品      |");
        System.out.println("|   6.退出食品管理   |");
        System.out.println("+-----------------+");
        System.out.print(">");
    }

    public Integer getMenu(Scanner sc) {
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
