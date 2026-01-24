package com.apress.spring6recipes.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 이벤트를 발생시키려면 ApplicationEventPublisher를 이용해야 하는데...
// 1. ApplicationEventPublisherAware 인터페이스 이용 - 약간 번잡스러워 보이고...
// public class Cashier implements ApplicationEventPublisherAware {
// 2. 스프링스럽게 빈 만들고 필드에 @Autowired나 생성자 주입...
@Component
public class Cashier {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    // 위 필드에 @Autowired 떼면 여기서 생성자 주입 필요함...
    // public Cashier(ApplicationEventPublisher applicationEventPublisher) {
    //     this.applicationEventPublisher = applicationEventPublisher;
    // }

    // 1번 방법에 의해 오버라이드 필요한데...이것도 약간 번잡스러워 보인다...
    // @Override
    // public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    //     this.applicationEventPublisher = applicationEventPublisher;
    // }

    public void checkout(ShoppingCart cart){
        var event = new CheckoutEvent(cart, LocalDateTime.now());
        applicationEventPublisher.publishEvent(event);
    }
}
