package com.apress.spring6recipes.sequence;

import com.apress.spring6recipes.sequence.config.SequenceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class Main {
    public static void main(String[] args) {

        // @ComponentScan을 사용하면 @Configuration 클래스를 지정하면 예외 발생...
        // var cfg = SequenceConfiguration.class;
        // try (var context = new AnnotationConfigApplicationContext(cfg)) {

        // 아래처럼 패키지 이름을 지정해야 한다.
        var basePackages = "com.apress.spring6recipes.sequence";
        try (var context = new AnnotationConfigApplicationContext(basePackages)) {
            // var sequenceDao = context.getBean("sequenceDao",SequenceDao.class);
            // 인터페이스의 클래스로 가져오는데, 거기 구현체는 스프링에서 만들어 넣어줬다?
            var sequenceDao = context.getBean(SequenceDao.class);
            System.out.println(sequenceDao.getNexValue("IT"));
            System.out.println(sequenceDao.getNexValue("IT"));
        }
    }
}
