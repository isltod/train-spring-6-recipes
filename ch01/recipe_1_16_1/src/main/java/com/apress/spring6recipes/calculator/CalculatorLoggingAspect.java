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

    // 여기서 표현식 한 번 쓰고, 다음부터는 표현식이 아니라 메서드 명으로 참조한다...
    // @Pointcut("execution(* *.*(..))")
    // private void anyMethod() {
    // }
    // 아니면 CalculatorPointcuts 따로 public으로 만들고 거기걸 갖다 쓴다...

    // 여기서 @Before에 anyMethod로 갔는데, 또 execution으로 갈 곳을 지정해서 결국 거기가서 로깅을 한다...
    // @Before("anyMethod()")
    // 밖에 걸 갖다 쓸 때는 전체 패키지 이름으로 참조해야 한다...근데 너무 길어지는데...이게 정말 더 좋나?
    @Before("com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info(
                "The method {}() begins with {}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())
        );
    }

    // @After("anyMethod()")
    @After("com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("The method {}() ends", joinPoint.getSignature().getName());
    }

    // @AfterReturning(pointcut = "anyMethod()", returning = "result")
    @AfterReturning(
            pointcut = "com.apress.spring6recipes.calculator.CalculatorPointcuts.anyMethod()",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    // @AfterThrowing(pointcut = "anyMethod()", throwing = "ex")
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

    // @Around("anyMethod()")
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
