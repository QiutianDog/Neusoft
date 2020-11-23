package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.dao.impl.AdminDaoImpl;
import com.neusoft.elm.obj.Admin;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.view.AdminView;

import java.util.List;
import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    private final Scanner sc = new Scanner(System.in);
    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login() {
        System.out.print("adminName:");
        String adminName = sc.next();

        System.out.print("password:");
        String password = sc.next();

        AdminDao dao = new AdminDaoImpl();

        return dao.getAdminByNameAndPassword(adminName, password);
    }

    @Override
    public void listBusiness() {
        List<Business> businesses = adminDao.listBusiness();
        for (Business business : businesses) {
            System.out.println(business);
        }
    }

    @Override
    public void saveBusiness() {
        // 账号密码必须合乎规范
        System.out.print("businessName:");
        String businessName = sc.next();

        System.out.print("password:");
        String password = sc.next();

        Integer integer = adminDao.saveBusiness(businessName, password);
        if (integer != null) {
            System.out.println("create business succeed! businessId = " + integer);
        } else {
            System.out.println("create business fault!");
        }
    }

    @Override
    public void removeBusiness() {
        System.out.print("businessId:");
        Integer businessId = Integer.valueOf(sc.next());
        int i = adminDao.removeBusiness(businessId);
        if (i == 1) {
            System.out.println("remove business succeed!");
        } else {
            System.out.println("remove business number = " + i);
        }
    }

    @Override
    public void updateBusiness() {
        System.out.print("businessId:");
        String businessId = sc.next();

        // 查找是否有这家店
        Business business = adminDao.selectBusinessById(Integer.valueOf(businessId));
        if (business != null) {
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

            int i = adminDao.updateBusiness(business);
            if (i == 1) {
                System.out.println("update business succeed!");
            } else {
                System.out.printf("update business have some problem, you changed %d lines\n", i);
            }
        } else {
            System.out.println("no info about " + businessId);
        }
    }

    @Override
    public void selectBusinessById() {
        System.out.print("businessId:");
        String businessId = sc.next();
        Business business = adminDao.selectBusinessById(Integer.valueOf(businessId));
        if (business != null) {
            System.out.println(business);
        } else {
            System.out.println("no info about businessId = " + businessId);
        }
    }
}
