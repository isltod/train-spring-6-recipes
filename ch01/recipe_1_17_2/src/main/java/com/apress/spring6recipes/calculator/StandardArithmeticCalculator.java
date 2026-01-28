package com.apress.spring6recipes.calculator;

import org.springframework.stereotype.Component;

@Component
// 이번에는 클래스에 붙이고...근데 이렇게만 붙여도 within 필요 없는거 아닌가? 아니네...클래스는 안되는 모양...
@LoggingRequired
public class StandardArithmeticCalculator implements ArithmeticCalculator{

    @Override
    public double add(double num1, double num2) {
        var result = num1 + num2;
        System.out.printf("%f + %f = %f\n", num1, num2, result);
        return result;
    }

    @Override
    public double sub(double num1, double num2) {
        var result = num1 - num2;
        System.out.printf("%f - %f = %f\n", num1, num2, result);
        return result;
    }

    @Override
    public double mul(double num1, double num2) {
        var result = num1 * num2;
        System.out.printf("%f * %f = %f\n", num1, num2, result);
        return result;
    }

    @Override
    public double div(double num1, double num2) {
        if (num2 == 0) {throw new IllegalArgumentException("Division by zero");}
        var result = num1 / num2;
        System.out.printf("%f / %f = %f\n", num1, num2, result);
        return result;
    }
}
