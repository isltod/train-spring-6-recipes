package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.DiscountFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

    @Bean
    public Battery aaa() {
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    public Disc cdrw() {
        return new Disc("CD-RW", 1.5, 700);
    }

    @Bean
    public Disc dvdrw() {
        return new Disc("DVD-RW", 3.0, 4700);
    }

    // 이걸 제품마다 다 이렇게 만들어준다...왜 이런 짓을...
    // 아무튼 이게 스프링 팩토리 빈을 커스텀한 팩토리 빈...말도 기네...
    @Bean
    public DiscountFactoryBean discountFactoryBeanAAA() {
        var factory = new DiscountFactoryBean();
        factory.setProduct(aaa());
        // 아니...그런데...팩토리를 이용해서 상품을 생성한게 아닌데 왜 할인이 적용되지?
        factory.setDiscount(0.2);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanCDRW() {
        var factory = new DiscountFactoryBean();
        factory.setProduct(cdrw());
        factory.setDiscount(0.1);
        return factory;
    }

    @Bean
    public DiscountFactoryBean discountFactoryBeanDVDRW() {
        var factory = new DiscountFactoryBean();
        factory.setProduct(dvdrw());
        factory.setDiscount(0.1);
        return factory;
    }
}
