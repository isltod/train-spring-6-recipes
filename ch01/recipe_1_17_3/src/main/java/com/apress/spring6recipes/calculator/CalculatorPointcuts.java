package com.apress.spring6recipes.calculator;

import org.aspectj.lang.annotation.Pointcut;

public class CalculatorPointcuts {

    // 적용될 때 대상 객체와 인수 값을 받아 쓰려면 이렇게...근데...
    // args 사용하니 $AmbiguousBindingException 예외 발생...build.gradle에 tasks.withType(JavaCompile) 해줘야 되는데...
    // 이러려니 그냥 joinPoint.getArgs()를 쓰는게 더 나을듯...
    @Pointcut("execution(* *.*(..)) && target(target) && args(num1, num2)")
    public void parameterPointCut(Object target, double num1, double num2) {
    }
}
