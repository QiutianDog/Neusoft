package com.neusoft.elm.view;

import com.neusoft.elm.obj.Food;

import java.util.List;

/**
 * 管理食物对象的接口
 * @author QiutianDog
 */
public interface FoodView {
    /**
     * 列出食品清单
     */
    void listFood();

    /**
     * 添加食品
     */
    void saveFood();

    /**
     * 删除食品
     */
    void removeFood();

    /**
     * 修改食物信息
     */
    void updateFood();

    /**
     * 通过食物Id查询食物
     */
    void selectFoodById();

}
