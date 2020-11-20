package com.neusoft.elm.dao;

import com.neusoft.elm.obj.Food;

import java.util.List;

public interface FoodDao {

    // 列出食品清单
    List<Food> listFood();

}
