package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Cashier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Configuration들 중에 오직 Global만 @ComponentScan이 있다...이걸로 다른 Configuration들을 찾게 만든다...
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfigurationGlobal {

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier() {
        var path = System.getProperty("java.io.tmpdir") + "cashier";
        System.out.println(path);
        return new Cashier(path);
    }
}
