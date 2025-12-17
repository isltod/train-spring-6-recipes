package com.apress.spring6recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.apress.spring6recipes.shop.Product;
import com.apress.spring6recipes.shop.ProductCreator;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

	// 정적 팩토리 메서드를 사용했다라...뭐가 다르지? 그냥 복잡도만 증가했는데...
	@Bean
	public Product aaa() {
		return ProductCreator.createProduct("aaa");
	}

	@Bean
	public Product cdrw() {
		return ProductCreator.createProduct("cdrw");
	}

	@Bean
	public Product dvdrw() {
		return ProductCreator.createProduct("dvdrw");
	}
}
