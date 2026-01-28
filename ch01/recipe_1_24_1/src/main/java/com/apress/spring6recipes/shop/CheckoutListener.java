package com.apress.spring6recipes.shop;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 이벤트를 듣고 뭔가를 하려면 implements ApplicationListener에 이벤트 타입을 지정한다...
// public class CheckoutListener implements ApplicationListener<CheckoutEvent> {
// 또는 다른 방법으로 스프링 빈 만들고, 메서드에 @EventListener 지정...
@Component
public class CheckoutListener {

    // implements ApplicationListener 필요한 오버라이드...
    // @Override
    // 이것도 이쪽이 더 명확한가?
    @EventListener(CheckoutEvent.class)
    public void onApplicationEvent(CheckoutEvent event) {
        System.out.printf("체크아웃 이벤트 발생 [%s]%n", event.getTime());
    }

    // 하지만 애플리케이션 컨텍스트가 내는 ContextClosedEvent, ContextRefreshedEvent,
    // RequestHandledEvent 받으려면 ApplicationListener 인터페이스를 구현해야 되나...
}
