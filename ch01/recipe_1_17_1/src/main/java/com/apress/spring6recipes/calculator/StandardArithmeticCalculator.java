package com.apress.spring6recipes.calculator;

import org.springframework.stereotype.Component;

@Component
public class StandardArithmeticCalculator implements ArithmeticCalculator{

    // 포인트컷에서 사용한 애너테이션 클래스를 이렇게 직접 필요한 곳에 붙인다...
    // 일견 적용이 명확해서 좋을 듯도 하지만...이걸 바꾸려면 다 찾아다녀서 불편할 것 같기도 하고...
    @LoggingRequired
    // 책에서는 @Override를 다 없앴는데, 굳이 그럴 필요가 있나?
    @Override
    public double add(double num1, double num2) {
        var result = num1 + num2;
        System.out.printf("%f + %f = %f\n", num1, num2, result);
        return result;
    }

    @LoggingRequired
    @Override
    public double sub(double num1, double num2) {
        var result = num1 - num2;
        System.out.printf("%f - %f = %f\n", num1, num2, result);
        return result;
    }

    @LoggingRequired
    @Override
    public double mul(double num1, double num2) {
        var result = num1 * num2;
        System.out.printf("%f * %f = %f\n", num1, num2, result);
        return result;
    }

    @LoggingRequired
    @Override
    public double div(double num1, double num2) {
        if (num2 == 0) {throw new IllegalArgumentException("Division by zero");}
        var result = num1 / num2;
        System.out.printf("%f / %f = %f\n", num1, num2, result);
        return result;
    }
}
