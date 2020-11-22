package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Admin;

/**
 * 管理员Dao
 * @author QiutianDog
 */
public interface AdminDao {

    /**
     * 管理员登录
     * @param adminName 账号
     * @param password 密码
     * @return 管理员对象
     */
    Admin getAdminByNameAndPassword(String adminName, String password);

}
