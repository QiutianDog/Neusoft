package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Food;

import java.util.List;

public interface FoodDao {

    // 列出食品清单
    List<Food> listFood();

    // 添加食品 返回值是添加成功的食品编号
    Integer saveFood(Food food);

    // 删除食品
    int removeFood(Integer foodId);

    // 修改食物
    int updateFood(Food food);

    // 查询食物
    Food selectFoodById(Integer foodId);

}
