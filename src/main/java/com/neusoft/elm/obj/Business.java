package com.neusoft.elm.obj;

import lombok.Data;

@Data
public class Business {
    // 商家信息
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;

    public Business() {
    }

    public Business(Integer businessId, String password, String businessName, String businessAddress, String businessExplain, Double starPrice, Double deliveryPrice) {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return String.format("Business{businessId=%-5d, password='%-6s', businessName='%-16s', businessAddress='%-16s', businessExplain='%-8s', starPrice=%-5.2f, deliveryPrice=%-5.2f}"
        , businessId, password, businessName, businessAddress, businessExplain, starPrice, deliveryPrice);
    }
}
