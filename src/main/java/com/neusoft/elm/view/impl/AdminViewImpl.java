package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.AdminDao;
import com.neusoft.elm.dao.impl.AdminDaoImpl;
import com.neusoft.elm.obj.Admin;
import com.neusoft.elm.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {

    private Scanner sc = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.printf("adminName:");
        String adminName = sc.next();

        System.out.printf("password:");
        String password = sc.next();

        AdminDao dao = new AdminDaoImpl();

        Admin admin = dao.getAdminByNameAndPassword(adminName, password);
        return admin;
    }
}
