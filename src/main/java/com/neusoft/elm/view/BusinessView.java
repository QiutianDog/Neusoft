package com.neusoft.elm.view;

import com.neusoft.elm.obj.Business;

/**
 * @author QiutianDog
 */
public interface BusinessView {

    /**
     * 显示所有的商家
      */
    void listBusiness();

    /**
     * 添加一个商家 返回值是添加成功的商家ID
      */
    void saveBusiness();

    /**
     * 删除商家
     */
    void removeBusiness();

    /**
     * 修改商家
      */
    void updateBusiness();

    /**
     * 通过ID查询商家
      */
    void selectBusinessById();

    /**
     * 商家登录
     * @return 商家对象
     */
    Business login();

}
