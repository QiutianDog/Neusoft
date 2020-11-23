package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Business;

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

    /**
     * 获取商家
     * @param businessId 指定商家
     * @return 商家对象
     */
    Business getBusinessById(Integer businessId);

    /**
     * 修改商家
     * @param business 修改后的商家信息
     * @return 修改操作返回的执行成功的行数
     */
    int updateBusiness(Business business);

    /**
     * 修改密码
     * @param businessId 指定商家
     * @param newPassword 新密码
     * @return 修改操作返回的执行成功的行数
     */
    int updateBusinessPassword(Integer businessId, String newPassword);

}
