package com.itheima.pojo;

import java.util.HashMap;

public class Order {
    private String orderId;            //订单id
    private HashMap<String,Product> productInfo;	//商品信息
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public HashMap<String, Product> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(HashMap<String, Product> productInfo) {
        this.productInfo = productInfo;
    }
}

