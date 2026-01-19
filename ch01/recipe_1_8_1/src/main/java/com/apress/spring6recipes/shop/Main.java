package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var context = new AnnotationConfigApplicationContext(ShopConfiguration.class)) {
            var aaa = context.getBean("aaa", Product.class);
            var cdrw =  context.getBean("cdrw", Product.class);
            var dvdrw =  context.getBean("dvdrw", Product.class);

            var cart1 = context.getBean("shoppingCart", ShoppingCart.class);
            cart1.addItem(aaa);
            cart1.addItem(cdrw);
            System.out.println("장바구니 1에는: " + cart1.getItems());
            var cart2 = context.getBean("shoppingCart", ShoppingCart.class);
            cart2.addItem(dvdrw);
            System.out.println("장바구니 2에는: " + cart2.getItems());

            var cashier = context.getBean("cashier", Cashier.class);
            cashier.checkout(cart1);
            cashier.checkout(cart2);
        }
    }
}
