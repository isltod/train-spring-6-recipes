package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Cashier;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.5, 700);
    }

    @Bean
    public Product dvdrw() {
        return new Disc("DVD-RW", 3.0, 4700);
    }

    // 이걸로 Cashier 빈을 만들면서 openFile 자동 실행, 끝날 때 closeFile 자동 실행
    //@Bean(initMethod = "openFile", destroyMethod = "closeFile")
    // 또는 여기서는 그냥 만들고, cashier에서 post pre 적용하는 방법도...
    @Bean
    public Cashier cashier() {
        System.out.println(System.getProperty("java.io.tmpdir"));
        var path = System.getProperty("java.io.tmpdir") + "/casher";
        return new Cashier("checkout", path);
    }
}
