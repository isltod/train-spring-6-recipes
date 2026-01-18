package com.apress.spring6recipes.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 나머지 빈들은 @Configuration 클래스에서 정의하고 cart 빈만 컴포넌트 스캔으로 등록...
@Component
@Scope("prototype")
// 이렇게 범위를 prototype으로 해야 손님마다 새로 카트 빈을 받을 수 있다...
public class ShoppingCart {

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems(){
        return Collections.unmodifiableList(items);
    }
}
