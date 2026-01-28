package com.apress.spring6recipes.shop;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

// 1. extends ApplicationEvent로 이벤트 클래스 만들고...하지만 뭔가 번잡스럽다...
// 이게 다 EventPublisher와 Listener를 상속 방식으로 구현해서 그런거라고...
// public class CheckoutEvent extends ApplicationEvent {
// 스프링스럽고 단순하게 @Component와 @Autowired를 사용하면 필요 없다고...
public class CheckoutEvent {

    // 속성으로 필요한 정보 담아서 사용...여기서는 카트와 체크아웃 시간
    private final ShoppingCart cart;
    private final LocalDateTime time;

    public CheckoutEvent(ShoppingCart cart, LocalDateTime time){
        // extends ApplicationEvent에서 필요한 코드...번잡스럽다...
        // super(cart);
        this.cart=cart;
        this.time=time;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
