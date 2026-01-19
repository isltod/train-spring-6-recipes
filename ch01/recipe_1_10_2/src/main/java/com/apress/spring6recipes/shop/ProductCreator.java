package com.apress.spring6recipes.shop;

import java.util.Map;

public class ProductCreator {

    private final Map<String, Product> products;

    public ProductCreator(Map<String, Product> products) {
        this.products = products;
    }

    // 이번에는 static 메서드가 아니라 인스턴스 메서드로 반환한다...
    public Product createProduct(String productId) {
        Product product = this.products.get(productId);
        if (product != null) {
            return product;
        }
        var msg = "Unknown product ID: " + productId;
        throw new IllegalArgumentException(msg);
    }
}
