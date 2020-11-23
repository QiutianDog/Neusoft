package com.neusoft.elm.view;

/**
 * @author QiutianDog
 * @Date 2020/11/23
 */
public interface FoodView {
    /**
     * 列出食品清单
     */
    void listFood();

    /**
     * 列出食品清单
     * @param businessId 指定商家
     */
    void listFood(Integer businessId);

    /**
     * 添加食品
     * @param businessId 指定商家
     */
    void saveFood(Integer businessId);

    /**
     * 删除食品
     * @param businessId 指定商家
     */
    void removeFood(Integer businessId);

    /**
     * 修改食物信息
     * @param businessId 指定商家
     */
    void updateFood(Integer businessId);

    /**
     * 通过食物Id查询食物
     * @param businessId 指定商家
     */
    void selectFoodById(Integer businessId);
}
