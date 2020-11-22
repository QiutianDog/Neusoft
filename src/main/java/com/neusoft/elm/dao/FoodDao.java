package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Food;

import java.util.List;

/**
 * 食物接口
 * @author QiutianDog
 */
public interface FoodDao {

    /**
     * 列出食品清单
     * @return 食品列表
     */
    List<Food> listFood();

    /**
     * 添加食品
     * @param food 食物对象
     * @return 添加成功的食品编号
     */
    Integer saveFood(Food food);

    /**
     * 删除食品
     * @param foodId 欲删除的食物Id
     * @return 删除操作所返回的行数
     */
    int removeFood(Integer foodId);

    /**
     * 修改食物信息
     * @param food 新的食物对象
     * @return 修改操作所返回的行数
     */
    int updateFood(Food food);

    /**
     * 通过食物Id查询食物
     * @param foodId 食物Id
     * @return 食物对象
     */
    Food selectFoodById(Integer foodId);

}
