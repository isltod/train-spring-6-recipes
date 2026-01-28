package com.apress.spring6recipes.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 여기는 @Component 안해도 찾나?
@Aspect
public class CalculatorPointcuts {

    // 이번에는 클래스에 @LoggingRequired를 붙여놔서...@within 필요...
    // @Pointcut("@within(com.apress.spring6recipes.calculator.LoggingRequired)")
    // 애너테이션 아니고 클래스에 붙이려면 @ 없이 그냥 within
    // @Pointcut("within(com.apress.spring6recipes.calculator.StandardArithmeticCalculator)")
    // calculator 패키지 아래 몽땅
    // @Pointcut("within(com.apress.spring6recipes.calculator.*)")
    // spring6recipes 아래의 아래...포함 몽땅...
    // @Pointcut("within(com.apress.spring6recipes..*)")
    // ArithmeticCalculator 인터페이스를 구현한 놈들 몽땅...
    // @Pointcut("within(ArithmeticCalculator+)")
    // ArithmeticCalculator 인터페이스와 UnitCalculator 인터페이스를 구현한 놈들 몽땅...
    @Pointcut("within(ArithmeticCalculator+) || within(UnitCalculator+)")
    public void anyMethod() {
    }
}
