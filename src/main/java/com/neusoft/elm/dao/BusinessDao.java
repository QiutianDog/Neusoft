package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Business;
import com.neusoft.elm.obj.Food;

import java.util.List;

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
     * 列出食品清单
     * @return 食品列表
     */
    List<Food> listFood();

    /**
     * 列出食品清单
     * @param businessId 指定商家
     * @return 食品列表
     */
    List<Food> listFood(Integer businessId);

    /**
     * 添加食品
     * @param businessId 指定商家Id
     * @param food 食物对象
     * @return 添加成功的食品编号
     */
    Integer saveFood(Integer businessId, Food food);

    /**
     * 删除食品
     * @param businessId 指定商家Id
     * @param foodId 欲删除的食物Id
     * @return 删除操作所返回的行数
     */
    int removeFood(Integer businessId, Integer foodId);

    /**
     * 修改食物信息
     * @param food 新的食物对象
     * @return 修改操作所返回的行数
     */
    int updateFood(Food food);

    /**
     * 通过食物Id查询食物
     * @param businessId 指定商家Id
     * @param foodId 食物Id
     * @return 食物对象
     */
    Food selectFoodById(Integer businessId, Integer foodId);

    /**
     * 修改商家密码
     * @param businessId 商家Id
     * @param newPassword 新密码
     * @return 修改操作所执行的行数
     */
    int updateBusinessPassword(Integer businessId, String newPassword);

}
