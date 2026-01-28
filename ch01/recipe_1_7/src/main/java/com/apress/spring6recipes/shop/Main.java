package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Locale;

public class Main {
    private static final String MSG = "The i18n message for %s is: %s%n";

    public static void main(String[] args) {
        var cfg = ShopConfiguration.class;

        try (var context = new AnnotationConfigApplicationContext(cfg)) {
            var alert = context.getMessage("alert.checkout", null, Locale.US);
            var alert_inventory = context.getMessage(
                    "alert.inventory.checkout",
                    new Object[]{"[DVD-RW 3.0]", LocalDateTime.now()},
                    Locale.US
            );
            System.out.printf(MSG, "alert.checkout", alert);
            System.out.printf(MSG,  "alert.inventory.checkout", alert_inventory);

            alert = context.getMessage("alert.checkout", null, Locale.KOREA);
            // 채울 문자열이 없으면 위처럼 null, 있으면 아래처럼 Object[]{배열}
            alert_inventory = context.getMessage(
                    "alert.inventory.checkout",
                    new Object[]{"[DVD-RW 3.0]", LocalDateTime.now()},
                    Locale.KOREA
            );
            System.out.printf(MSG, "alert.checkout", alert);
            System.out.printf(MSG,  "alert.inventory.checkout", alert_inventory);

            // 다른 클래스에서 국제화 메시지 이용하려면...스프링 MessageSorce 사용
            ShoppingCart cart = context.getBean(ShoppingCart.class);
            cart.addItem(new Product("[DVD-RW 3.0]", 2.5, 0.3));
            Cachier cachier = context.getBean(Cachier.class);
            cachier.checkout(cart);
        }
    }
}
