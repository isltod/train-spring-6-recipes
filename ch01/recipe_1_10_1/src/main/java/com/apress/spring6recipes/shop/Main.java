package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ShopConfiguration.class)) {
            var aaa = context.getBean("aaa", Product.class);
            var cdrw = context.getBean("cdrw", Product.class);
            var dvdrw = context.getBean("dvdrw", Product.class);
            // 위에는 같은 Product 타입이므로 이름과 타입, 아래는 딱 하나뿐인 ShoppingCart 타입이므로 타입만..
            var cart1 = context.getBean(ShoppingCart.class);
            cart1.addItem(aaa);
            cart1.addItem(cdrw);
            System.out.println("Shopping cart 1: " + cart1.getItems());

            var cart2 = context.getBean(ShoppingCart.class);
            cart2.addItem(dvdrw);
            System.out.println("Shopping cart 2: " + cart2.getItems());
        }
    }
}
