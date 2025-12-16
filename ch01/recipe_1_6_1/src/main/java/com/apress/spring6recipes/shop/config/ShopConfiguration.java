package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// classpath가 src/main/resources인가?
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

    // 아래 클래스 필드에 discounts.properties 파일에서 endofyear.discount 값을 넣고, 없으면 0
    @Value("${endofyear.discount:0}")
    private double specialEndOfYearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer pspc() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product dvdrw() {
        return new Disc("DVD-RW", 1.5, 4700, specialEndOfYearDiscountField);
    }
}
