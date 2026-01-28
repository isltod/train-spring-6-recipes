package com.apress.spring6recipes.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.apress.spring6recipes.shop.Product;
import com.apress.spring6recipes.shop.ProductCreator;

@Configuration
// 여기서도 @ComponentScan은 ShoppingCart 클래스 하나를 위해 필요...
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

	// 정적 팩토리 메서드를 사용했다라...결국 같은 결과인데, 이런 방법도 있다 정도...
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
