package com.neusoft.elm.view.impl;

import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.impl.BusinessDaoImpl;
import com.neusoft.elm.obj.Business;
import com.neusoft.elm.obj.Food;
import com.neusoft.elm.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/**
 * @author QiutianDog
 */
public class BusinessViewImpl implements BusinessView {

    private final BusinessDao businessDao = new BusinessDaoImpl();
    private final Scanner sc = new Scanner(System.in);


    @Override
    public Business login() {
        System.out.print("BusinessId:");
        int businessId = sc.nextInt();

        System.out.print("password:");
        String password = sc.next();
        return businessDao.getBusinessByIdAndPassword(businessId, password);
    }

    @Override
    public void listFood() {
        List<Food> foods = businessDao.listFood();
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    @Override
    public void listFood(Integer businessId) {
        List<Food> foods = businessDao.listFood(businessId);
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        System.out.print("foodName:");
        String foodName = sc.next();

        System.out.print("foodExplain:");
        String foodExplain = sc.next();

        System.out.print("foodExplain:");
        Double foodPrice = sc.nextDouble();

        Food food = new Food(null, foodName, foodExplain, foodPrice, businessId);
        Integer foodId = businessDao.saveFood(businessId, food);
        if (foodId != null) {
            System.out.println("create food succeed! foodId = " + foodId);
        } else {
            System.out.println("create food fault!");
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.print("foodId:");
        int foodId = sc.nextInt();
        int i = businessDao.removeFood(businessId, foodId);
        if (i == 1) {
            System.out.printf("remove food %d succeed!\n", foodId);
        } else {
            System.out.printf("remove fault, maybe foodId %d is wrong.\n", foodId);
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        System.out.print("foodId:");
        int foodId = sc.nextInt();

        // 查找是否有这个食物
        Food food = businessDao.selectFoodById(businessId, foodId);
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

            int i = businessDao.updateFood(food);
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
    public void selectFoodById(Integer businessId) {
        System.out.print("foodId:");
        int foodId = sc.nextInt();
        Food food = businessDao.selectFoodById(businessId, foodId);
        if (food != null) {
            System.out.println(food);
        } else {
            System.out.println("not found!");
        }
    }
}
