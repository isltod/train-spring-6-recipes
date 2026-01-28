package com.apress.spring6recipes.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 여기는 @Component 안해도 찾나?
@Aspect
public class CalculatorPointcuts {

    @Pointcut("execution(* *.*(..))")
    // 포인트컷 따로 만들고 밖에서 참조하려면 접근자를 반드시 public으로...
    public void anyMethod() {
    }

}
