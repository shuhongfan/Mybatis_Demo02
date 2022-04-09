package com.itheima.controller;

import com.itheima.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    /**
     * 获取商品列表
     */
//    @RequestMapping("/getProducts")
//    public void getProducts(String[] proIds) {
//        for (String proId : proIds) {
//            System.out.println("获取到了Id为" + proId + "的商品");
//        }
//    }

    /**
     * 获取商品列表(使用List绑定数据)
     */
    @RequestMapping("/getProducts")
    public void getProducts(@RequestParam("proIds") List<String> proIds) {
        for (String proId : proIds) {
            System.out.println("获取到了Id为" + proId + "的商品");
        }
    }

    /**
     * 获取单个商品信息
     */
    @RequestMapping("/getProduct")
    public void getProduct(@RequestBody Product product) {
        String proId = product.getProId();
        String proName = product.getProName();
        System.out.println("获取到了Id为" + proId + "名称为" + proName + "的商品");
    }

    /**
     * 获取多个商品信息
     */
    @RequestMapping("/getProductList")
    public void getProductList(@RequestBody List<Product> products) {
        for (Product product : products) {
            String proId = product.getProId();
            String proName = product.getProName();
            System.out.println("获取到了Id为" + proId + "名称为" +
                    proName + "的商品");
        }
    }


}

