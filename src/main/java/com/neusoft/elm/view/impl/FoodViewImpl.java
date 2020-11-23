package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.impl.FoodDaoImpl;
import com.neusoft.elm.obj.Food;
import com.neusoft.elm.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author QiutianDog
 */
public class FoodViewImpl implements FoodView {

    private final FoodDao foodDao = new FoodDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void listFood() {
        List<Food> foods = foodDao.listFood();
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    @Override
    public void saveFood() {
        System.out.print("foodName:");
        String foodName = sc.next();

        System.out.print("foodExplain:");
        String foodExplain = sc.next();

        System.out.print("foodExplain:");
        Double foodPrice = sc.nextDouble();

        System.out.print("foodExplain:");
        Integer businessId = sc.nextInt();

        Food food = new Food(null, foodName, foodExplain, foodPrice, businessId);
        Integer foodId = foodDao.saveFood(food);
        if (foodId != null) {
            System.out.println("create food succeed! foodId = " + foodId);
        } else {
            System.out.println("create food fault!");
        }
    }

    @Override
    public void removeFood() {
        System.out.print("foodId:");
        int foodId = sc.nextInt();
        int i = foodDao.removeFood(foodId);
        if (i == 1) {
            System.out.printf("remove food %d succeed!\n", foodId);
        } else {
            System.out.printf("remove fault, maybe foodId %d is wrong.\n", foodId);
        }
    }

    @Override
    public void updateFood() {
        System.out.print("foodId:");
        int foodId = sc.nextInt();

        // 查找是否有这个食物
        Food food = foodDao.selectFoodById(foodId);
        if (food != null) {
            // 如果有的话就修改信息
            System.out.println("please input some information!");
            System.out.println("'null' or info");
            String change = "null";

            System.out.print("foodName:");
            String foodName = sc.next();
            if (!change.equals(foodName)) {
                food.setFoodName(foodName);
            }

            System.out.print("foodExplain:");
            String foodExplain = sc.next();
            if (!change.equals(foodExplain)) {
                food.setFoodExplain(foodExplain);
            }


            System.out.print("foodPrice:");
            String foodPrice = sc.next();
            if (!change.equals(foodPrice)) {
                food.setFoodPrice(Double.valueOf(foodPrice));
            }

            System.out.print("businessId:");
            String businessId = sc.next();
            if (!change.equals(businessId)) {
                food.setBusinessId(Integer.valueOf(businessId));
            }

            int i = foodDao.updateFood(food);
            if (i == 1) {
                System.out.println("update food succeed!");
            } else {
                System.out.printf("update food have some problem, you changed %d lines\n", i);
            }
        } else {
            System.out.printf("no such food, you may input the wrong foodId = %d\n", foodId);
        }
    }

    @Override
    public void selectFoodById() {
        System.out.print("foodId:");
        int foodId = sc.nextInt();
        Food food = foodDao.selectFoodById(foodId);
        if (food != null) {
            System.out.println(food);
        } else {
            System.out.println("not found!");
        }
    }
}
