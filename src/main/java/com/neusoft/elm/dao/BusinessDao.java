package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Business;

import java.util.List;

public interface BusinessDao {

    // 显示所有的商家
    List<Business> listBusiness();

    // 添加一个商家 返回值是添加成功的商家ID
    Integer saveBusiness(String businessName, String password);

    // 删除商家
    int removeBusiness(Integer businessId);

    // 修改商家
    int updateBusiness(Business business);

    // 通过ID查询商家
    Business selectBusinessById(Integer businessId);

}
