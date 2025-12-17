package com.apress.spring6recipes.shop;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductCheckBeanPostProcessor implements BeanPostProcessor {

    private static final String MSG = "----ProductCheckBeanPostProcessor.%s, processing Product: %s%n----";

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Product product) {
            var productName = product.getName();
            System.out.printf(MSG, "postProcessBeforeInitialization", productName);
        }
        return bean;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Product product) {
            var productName = product.getName();
            System.out.printf(MSG, "postProcessAfterInitialization", productName);
        }
        return bean;
    }
}
