package com.neusoft.elm.view;

import com.neusoft.elm.obj.Business;

/**
 * @author QiutianDog
 */
public interface BusinessView {

    /**
     * 商家登录
     * @return 商家对象
     */
    Business login();

    /**
     * 显示商家信息
     * @param businessId 指定商家
     */
    void outputBusinessById(Integer businessId);

    /**
     * 修改商家信息
     * @param businessId 指定商家
     */
    void updateBusiness(Integer businessId);

    /**
     * 修改商家密码
     * @param businessId 指定商家
     */
    void updateBusinessPassword(Integer businessId);

    /**
     * 管理食物
     * @param businessId 指定商家
     */
    void controlFood(Integer businessId);

}
