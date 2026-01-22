package com.apress.spring6recipes.calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var cfg = CalculatorConfiguration.class;
        try (var context = new AnnotationConfigApplicationContext(cfg)){

            var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);

            // casting이라는 형식을 빌려 arithmeticCalculator를 MaxCalculator로 바꾼다?
            // 라기 보다는 arithmeticCalculator는 뭔 일이 있는지도 모르고 그냥 명의만 빌려주는 꼴...
            var maxCalculator = (MaxCalculator) arithmeticCalculator;
            maxCalculator.max(1, 2);

            var minCalculator = (MinCalculator) arithmeticCalculator;
            minCalculator.min(1, 2);

            // 이렇게 해도 똑같은 결과...그럼 왜 헷갈리게 굳이 상관도 없는 arithmeticCalculator를 거치나...
            context.getBean(MaxCalculator.class).max(1, 2);
        }
    }
}
