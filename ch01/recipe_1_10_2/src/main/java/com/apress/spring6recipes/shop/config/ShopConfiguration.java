package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.Battery;
import com.apress.spring6recipes.shop.Disc;
import com.apress.spring6recipes.shop.Product;
import com.apress.spring6recipes.shop.ProductCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

    // 인스턴스 메서드로 만들면, 여기서 필요 속성을 넣어 인스턴스를 만들고,
    @Bean
    public ProductCreator productCreatorFactory() {
        var products = Map.of(
                "aaa", new Battery("AAA", 2.5, true),
                "cdrw", new Disc("CD-RW", 1.5, 700),
                "dvdrw", new Disc("DVD-RW", 3.0, 4700)
        );
        return new ProductCreator(products);
    }

    // 다시 그 인스턴스 빈의 createProduct를 호출한다...
    @Bean
    public Product aaa(ProductCreator productCreator) {
        return productCreator.createProduct("aaa");
    }

    @Bean
    public Product cdrw(ProductCreator productCreator) {
        return productCreator.createProduct("cdrw");
    }

    @Bean
    public Product dvdrw(ProductCreator productCreator) {
        return productCreator.createProduct("dvdrw");
    }
}
