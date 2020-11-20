package com.neusoft.elm.obj;

import lombok.Data;

@Data
public class Food {
    // 食物
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;

    public Food() {
    }

    public Food(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodExplain='" + foodExplain + '\'' +
                ", foodPrice=" + foodPrice +
                ", businessId=" + businessId +
                '}';
    }
}
