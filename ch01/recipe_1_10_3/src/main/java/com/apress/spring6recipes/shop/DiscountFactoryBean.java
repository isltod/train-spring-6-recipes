package com.apress.spring6recipes.shop;

import org.springframework.beans.factory.config.AbstractFactoryBean;

// 이게 스프링 팩토리 빈을 상속한 커스텀 팩토리 빈이라고...거의 쓸 일이 없다고...
public class DiscountFactoryBean extends AbstractFactoryBean<Product> {

    private Product product;
    private double discount;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // 이게 자동 와이어링 기능이 작동하기 위한 조건이고...
    @Override
    public Class<?> getObjectType() {
        return product.getClass();
    }

    // 상품 빈 인스턴스를 만들면서 바로 디스카운트...
    @Override
    protected Product createInstance() throws Exception {
        product.setPrice(product.getPrice() * (1 - discount));
        return product;
    }
}
