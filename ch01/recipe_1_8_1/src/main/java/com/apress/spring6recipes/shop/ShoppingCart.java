package com.apress.spring6recipes.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
// 이걸 지정하면 다른데서 불러질 때까지 기다렸다가 초기화 한다고...근데 지금은 이점이 뭔지 잘 모르겠네...
// @Autowired와 함께 사용하면 DI를 지연시킬 수도 있다...
@Lazy
public class ShoppingCart {

	private List<Product> items = new ArrayList<>();

	public void addItem(Product item) {
		this.items.add(item);
	}

	public List<Product> getItems() {
		return Collections.unmodifiableList(this.items);
	}

}
