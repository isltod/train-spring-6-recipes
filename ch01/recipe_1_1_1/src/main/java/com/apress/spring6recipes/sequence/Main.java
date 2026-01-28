package com.apress.spring6recipes.sequence;

import com.apress.spring6recipes.sequence.config.SequenceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var cfg = SequenceConfiguration.class;

        // 이 코드로 IoC 컨테이너 생성 - 이렇게 해야 스프링이 @Configuration, @Bean 어노테이션을 인식
        // 이거 외에도 BeanFactory도 있지만, 이게 더 좋으므로 가급적 이걸로 쓰자...
        try (var ctx = new AnnotationConfigApplicationContext(cfg)) {
            var generator = ctx.getBean(Sequence.class);
            // 빈을 얻어오는 방법은 이 외에도 아래 두 가지가 있지만, 가능하면 위가 편하다...
            // var generator = ctx.getBean("simpleSequence", Sequence.class);
            // var generator = (Sequence) ctx.getBean("simpleSequence");
            System.out.println(generator.nextValue());
            System.out.println(generator.nextValue());
        }
    }
}
