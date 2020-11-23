package com.neusoft.elm.view;

import com.neusoft.elm.obj.Admin;

/**
 * 管理员界面接口
 * @author QiutianDog
 */
public interface AdminView {

    /**
     * 登录管理员账号
     * @return 管理员对象
     */
    Admin login();

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

}
