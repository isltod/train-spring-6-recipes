package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfigurationGlobal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (var context = new AnnotationConfigApplicationContext()) {
            // 위와 아래는 사실 AnnotationConfigApplicationContext(ShopConfigurationGlobal.class)를 나눠 넣은 거지만...
            // 아래 환경 설정을 하고 refresh를 하려면 이렇게 나눠 넣어야 하나보다...
            context.register(ShopConfigurationGlobal.class);
            // setActiveProfiles 또는 setDefaultProfiles 사용...
            context.getEnvironment().setActiveProfiles("spring");
            // context.getEnvironment().setDefaultProfiles("spring");
            // 또는 -Dspring.profiles.active=winter 또는 spring.profiles.default 옵션 사용
            context.refresh();

            var aaa = context.getBean("aaa", Product.class);
            var cdrw = context.getBean("cdrw", Product.class);
            var dvdrw = context.getBean("dvdrw", Product.class);

            var cart1 = context.getBean("shoppingCart", ShoppingCart.class);
            cart1.addItem(aaa);
            cart1.addItem(cdrw);
            System.out.println("Shopping cart 1 contains " + cart1.getItems());

            var cart2 = context.getBean("shoppingCart", ShoppingCart.class);
            cart2.addItem(dvdrw);
            System.out.println("Shopping cart 2 contains " + cart2.getItems());

            var cashier = context.getBean("cashier", Cashier.class);
            cashier.checkout(cart1);
            cashier.checkout(cart2);
        }
    }
}
