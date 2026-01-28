package com.apress.spring6recipes.calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var cfg = CalculatorConfiguration.class;
        try (var context = new AnnotationConfigApplicationContext(cfg)){

            var arithmaticCalculator = context.getBean(ArithmeticCalculator.class);
            arithmaticCalculator.add(10, 20);
            arithmaticCalculator.sub(4, 3);
            arithmaticCalculator.mul(2, 3);
            arithmaticCalculator.div(4, 2);

            var unitCalculator = context.getBean(UnitCalculator.class);
            unitCalculator.kilogramToPounds(10);
            unitCalculator.kilometerToMiles(5);
        }
    }
}
