package com.apress.spring6recipes.shop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// 이 클래스를 만들고 아래 두 메서드에서 생성 전후 처리...
@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {

    // 둘 다 반환 타입은 Objec이고 아무 일도 안해도 bean을 반환해야 한다...
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        var msg = "In postProcessBeforeInitialization, processing bean type: %s%n";
        System.out.printf(msg, bean.getClass().getName());
        // 특정 타입에 대해서만 전/후처리 하고 싶다면 이렇게 타입 검사...
        if (bean instanceof Product product) {
            var productName = product.getName();
            System.out.println("Especially " + productName + " postProcessBeforeInitialization");
        }
        // 뭐에 쓸지는 모르겠지만, 여기서 다른 객체를 반환하면 빈 인스턴스를 아예 다른 것으로 바꿀 수도 있다...
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        var msg = "In postProcessAfterInitialization, processing bean type: %s%n";
        System.out.printf(msg, bean.getClass().getName());
        return bean;
    }
}
