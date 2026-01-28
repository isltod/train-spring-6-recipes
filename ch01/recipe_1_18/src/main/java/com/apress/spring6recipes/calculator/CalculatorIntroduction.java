package com.apress.spring6recipes.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

// 인트로덕션 클래스라는 건 기존의 AOP 클래스처럼 만드는 것...
@Aspect
@Component
public class CalculatorIntroduction {

    // 사용될 메서드들을 속성처럼 설정해놓고 사용한다...
    @DeclareParents(
            value = "com.apress.spring6recipes.calculator.StandardArithmeticCalculator",
            defaultImpl = SimpleMaxCalculator.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "com.apress.spring6recipes.calculator.StandardArithmeticCalculator",
            defaultImpl = SimpleMinCalculator.class
    )
    public MinCalculator minCalculator;

}
