package com.apress.spring6recipes.sequence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext()) {
            // AnnotationConfigApplicationContext를 사용했지만 이게 GenericApplicationContext의 구현체...
            // registerBean은 GenericApplicationContext에서 온거라고...
            // 일단 첫 번째로 타입 + Supplier 매개변수로 빈 생성
            context.registerBean(Sequence.class, () -> new Sequence("30", "A", 10000));
            // 여기서 빈 인스턴스가 생성된다..
            context.refresh();
            var generator = context.getBean(Sequence.class);

            System.out.println(generator.nextValue());
            System.out.println(generator.nextValue());
        }
    }
}
