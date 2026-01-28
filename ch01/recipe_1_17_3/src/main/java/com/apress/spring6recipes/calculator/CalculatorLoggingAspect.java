package com.apress.spring6recipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Aspect 만으로는 스프링이 자동으로 찾아주지 않아서 @Component 함께 붙인다고...
@Aspect
@Component
public class CalculatorLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // args 사용하니 $AmbiguousBindingException 예외 발생...build.gradle에 tasks.withType(JavaCompile) 해줘야 되는데...
    // 이러려니 그냥 joinPoint.getArgs()를 쓰는게 더 나을듯...
    @Before("com.apress.spring6recipes.calculator.CalculatorPointcuts.parameterPointCut(target, num1, num2)")
    public void logParameter(Object target, double num1, double num2) {
        logger.info("Target class: {}", target.getClass().getName());
        logger.info("Arguments: {}, {}", num1, num2);
    }
}
