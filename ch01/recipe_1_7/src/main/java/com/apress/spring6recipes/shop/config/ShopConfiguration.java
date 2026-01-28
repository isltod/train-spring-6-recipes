package com.apress.spring6recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.apress.spring6recipes.shop.Cachier;
import com.apress.spring6recipes.shop.ShoppingCart;

@Configuration
public class ShopConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        // resources 아래에서 messages로 시작하는 파일이라고...messages_언어코드_국가코드.properties
        // ko KR은 getMessage에서 Locale.KOREA로 지정하면 자동으로 그 파일을 찾는다...
        messageSource.setBasename("classpath:messages");
        // 실제로 파일이 변하지 않으면 캐싱을 하지 않으므로 적당히 짧게 주는게 좋다...
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    @Bean
    public Cachier cachier() {
        return new Cachier();
    }

    @Bean
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
