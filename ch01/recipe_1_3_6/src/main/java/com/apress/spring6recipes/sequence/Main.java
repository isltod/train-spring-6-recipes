package com.apress.spring6recipes.sequence;

import com.apress.spring6recipes.sequence.config.PrefixConfiguration;
import com.apress.spring6recipes.sequence.config.SequenceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // @Configuration 여러개 사용할 때는 {안에 ,로 나열해서} Class[] 배열로 전달
        var cfg = new Class[]{PrefixConfiguration.class, SequenceConfiguration.class};

        try (var context = new AnnotationConfigApplicationContext(cfg)) {
            var generator = context.getBean("sequence", Sequence.class);

            System.out.println(generator.nextValue());
            System.out.println(generator.nextValue());
        }
    }
}
