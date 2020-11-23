package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.view.BusinessView;

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
        int BusinessId = sc.nextInt();

        System.out.print("password:");
        String password = sc.next();
        return businessDao.getBusinessByIdAndPassword(BusinessId, password);
    }
}
