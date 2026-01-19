package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.DiscountFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 여기서도 @ComponentScan은 오직 하나 ShoppingCart만을 위한...
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

    // 스프링이 자동으로 @Bean discountFactoryBeanAAA을 생성하므로, 
    // 위에서 생성한 aaa Product는 아래 setDiscount가 적용된다...
    // 그러니까 만든 POJO를 뭔가 다르게 초기화시키고 싶을 때 커스텀 팩토리 빈을 사용한다?
    // 이걸 제품마다 다 이렇게 만들어준다...뭐..이런 것도 있다...
    // 아무튼 이게 스프링 팩토리 빈을 커스텀한 팩토리 빈...말도 기네...
    @Bean
    public DiscountFactoryBean discountFactoryBeanAAA() {
        var factory = new DiscountFactoryBean();
        factory.setProduct(aaa());
        // 팩토리에서 setDiscount 메서드로 product의 price를 변경해준다...
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
