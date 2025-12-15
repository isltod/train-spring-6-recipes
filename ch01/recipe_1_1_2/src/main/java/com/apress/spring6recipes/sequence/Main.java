package com.apress.spring6recipes.sequence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var basePackages = "com.apress.spring6recipes.sequence";

        try (var context = new AnnotationConfigApplicationContext(basePackages)) {
            // 인터페이스의 클래스로 가져오는데, 거기 구현체는 스프링에서 만들어 넣어줬다?
            var sequenceDao = context.getBean(SequenceDao.class);
            System.out.println(sequenceDao.getNexValue("IT"));
            System.out.println(sequenceDao.getNexValue("IT"));
        }
    }
}
