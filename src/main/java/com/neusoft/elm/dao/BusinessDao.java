package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Business;

import java.util.List;

/**
 * 商家Dao层
 * @author QiutianDog
 */
public interface BusinessDao {

    /**
     * 商家登录
     * @param businessId 账号
     * @param password 密码
     * @return 商家对象
      */
    Business getBusinessByIdAndPassword(Integer businessId, String password);

}
