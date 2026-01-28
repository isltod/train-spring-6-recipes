package com.apress.spring6recipes.calculator;

import org.springframework.stereotype.Component;

@Component
public class StandardComplexCalculator implements ComplexCalculator {

    @Override
    public Complex add(Complex c1, Complex c2) {
        // 복소수 객체를 받아서 새 복소수 객체를 생성한다...
        var result = new Complex(c1.real() + c2.real(), c1.imag() + c2.imag());
        System.out.printf("%s + %s = %s%n", c1, c2, result);
        return result;
    }

    @Override
    public Complex sub(Complex c1, Complex c2) {
        var result = new Complex(c1.real() - c2.real(), c1.imag() - c2.imag());
        System.out.printf("%s - %s = %s%n", c1, c2, result);
        return result;
    }
}
