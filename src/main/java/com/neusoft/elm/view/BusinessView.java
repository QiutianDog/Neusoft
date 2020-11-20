package com.neusoft.elm.view;

import com.neusoft.elm.obj.Business;

public interface BusinessView {

    // 显示所有的商家
    boolean listBusiness();

    // 添加一个商家 返回值是添加成功的商家ID
    boolean saveBusiness();

    // 删除商家
    boolean removeBusiness();

    // 修改商家
    boolean updateBusiness();

    // 通过ID查询商家
    boolean selectBusinessById();

}
