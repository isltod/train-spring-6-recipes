package com.apress.spring6recipes.calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var cfg = CalculatorConfiguration.class;
        try (var context = new AnnotationConfigApplicationContext(cfg)){

            var arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
            arithmeticCalculator.add(10, 20);
            arithmeticCalculator.sub(4, 3);
            arithmeticCalculator.mul(2, 3);
            arithmeticCalculator.div(4, -1);

            var unitCalculator = context.getBean(UnitCalculator.class);
            unitCalculator.kilogramToPounds(10);
            unitCalculator.kilometerToMiles(5);
        }
    }
}
