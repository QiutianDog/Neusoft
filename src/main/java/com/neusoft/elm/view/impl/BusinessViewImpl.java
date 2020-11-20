package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {

    private BusinessDao businessDao = new BusinessDaoImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public boolean listBusiness() {
        List<Business> businesses = businessDao.listBusiness();
        for (Business business : businesses) {
            System.out.println(business);
        }
        return true;
    }

    @Override
    public boolean saveBusiness() {
        // 账号密码必须合乎规范
        System.out.printf("businessName:");
        String businessName = sc.next();

        System.out.printf("password:");
        String password = sc.next();

        Integer integer = businessDao.saveBusiness(businessName, password);
        if (integer == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBusiness() {
        System.out.printf("businessId");
        Integer businessId = Integer.valueOf(sc.next());
        int i = businessDao.removeBusiness(businessId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBusiness() {
        return false;
    }

    @Override
    public boolean selectBusinessById() {
        return false;
    }
}
