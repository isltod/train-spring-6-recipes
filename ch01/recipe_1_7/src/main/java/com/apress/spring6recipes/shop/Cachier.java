package com.apress.spring6recipes.shop;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Cachier {

    // 이 녀석은 스프링 MessageSource, 
    // 스프링이라서 @Autowired되고 @Configuration에서 읽어놓은 메시지에도 접근 가능하다고...
    @Autowired
    private MessageSource messageSource;

    public void checkout(ShoppingCart cart) {
        var alert = messageSource.getMessage(
            "alert.inventory.checkout", 
            new Object[]{cart.getItems(), new Date()}, 
            Locale.KOREA);
        System.out.println(alert);
    }
}
