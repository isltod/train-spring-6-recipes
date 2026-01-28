package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart = context.getBean("shoppingCart", ShoppingCart.class);
        cart.addItem(dvdrw);

        System.out.println("Shopping cart contains " + cart.getItems());

        ((AnnotationConfigApplicationContext) context).close();
    }
}
