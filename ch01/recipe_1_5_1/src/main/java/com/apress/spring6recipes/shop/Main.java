package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var cfg = ShopConfiguration.class;

        try (var context = new AnnotationConfigApplicationContext(cfg)) {
            var aaa = context.getBean("aaa", Product.class);
            var cdrw = context.getBean("cdrw", Product.class);
            var dvdrw = context.getBean("dvdrw", Product.class);

            // 첫 번째 손님 장바구니
            var cart1 = context.getBean(ShoppingCart.class);
            cart1.addItem(aaa);
            cart1.addItem(cdrw);
            System.out.println("Shopping cart 1: " + cart1.getItems());

            // 두 번째 손님 장바구니
            var cart2 = context.getBean(ShoppingCart.class);
            cart2.addItem(dvdrw);
            // 원래 결과는 여기서 위에 cart1에 담겨있는 상품들이 같이 들어있다...
            // 결국 cart1과 cart2는 같은 인스턴스를 참조한다...
            // 그래서 cart 빈은 @Scope prototype으로 지정...
            System.out.println("Shopping cart 2: " + cart2.getItems());
        }
    }
}
