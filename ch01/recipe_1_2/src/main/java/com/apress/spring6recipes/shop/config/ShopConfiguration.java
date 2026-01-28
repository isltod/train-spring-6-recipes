package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

    // 1-1-1 처럼 생성자로 빈을 만드는 방법, 여기서는 속성도 setter가 아니라 생성자로...
    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.5, 700);
    }
}
