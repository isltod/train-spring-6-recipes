package com.apress.spring6recipes.shop;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

    // 이 클래스를 만들고 아래 두 메서드에서 생성 전후 처리...
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        var msg = "In AuditCheckBeanPostProcessor.postProcessBeforeInitialization, processing bean type: %s%n";
        System.out.printf(msg, bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var msg = "In AuditCheckBeanPostProcessor.postProcessAfterInitialization, processing bean type: %s%n";
        System.out.printf(msg, bean.getClass().getName());
        return bean;
    }
}
