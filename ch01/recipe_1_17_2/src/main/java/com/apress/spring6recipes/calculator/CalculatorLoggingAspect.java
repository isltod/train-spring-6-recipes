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

    // 여기서는 1-16과 동일하게 하면 되고...오히려 대상인 StandardArithmeticCalculator에 애너테이션을 붙인다..
    @Before("com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info(
                "The method {}() begins with {}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        );
    }

    @After("com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("The method {}() ends", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()",
            throwing = "ex"
    )
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.info(
                "Illegal arguments {} in {}()",
                Arrays.toString(joinPoint.getArgs()),
                joinPoint.getSignature().getName()
        );
    }

    @Around("com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        var name = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        logger.info("The method {}() begins with {}", name, args);
        try {
            var result = joinPoint.proceed();
            logger.info("The method {}() ends with {}", name, result);
            return result;
        } catch (IllegalArgumentException e) {
            logger.error("Illegal arguments {} in {}()", args, name, e);
            throw e;
        }
    }
}
