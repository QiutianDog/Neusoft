package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Business;

import java.util.List;

/**
 * 商家Dao层
 * @author QiutianDog
 */
public interface BusinessDao {

    /**
     * 显示所有的商家
     * @return 商家列表
     */
    List<Business> listBusiness();

    /**
     * 添加一个商家 返回值是添加成功的商家ID
     * @param businessName 新建商家的名字
     * @param password 新建商家的密码
     * @return 新建商家自动生成的 Id
     */
    Integer saveBusiness(String businessName, String password);

    /**
     * 删除商家
     * @param businessId 欲删除的商家Id
     * @return 删除操作返回的执行成功的行数
     */
    int removeBusiness(Integer businessId);

    /**
     * 修改商家
     * @param business 修改后的商家信息
     * @return 修改操作返回的执行成功的行数
     */
    int updateBusiness(Business business);

    /**
     * 通过ID查询商家
     * @param businessId 商家Id
     * @return 商家 可能为 null
     */
    Business selectBusinessById(Integer businessId);

    /**
     * 商家登录
     * @param businessId 账号
     * @param password 密码
     * @return 商家对象
      */
    Business getBusinessByIdAndPassword(Integer businessId, String password);

}
