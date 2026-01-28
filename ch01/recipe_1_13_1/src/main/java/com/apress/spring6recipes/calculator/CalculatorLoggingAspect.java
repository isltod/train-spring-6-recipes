package com.apress.spring6recipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Aspect 만으로는 스프링이 자동으로 찾아주지 않아서 @Component 함께 붙인다고...
@Aspect
@Component
public class CalculatorLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 1. * - 모든 접근 제어, 모든 반환 타입
    // 2. *.* 클래스.메서드
    // 3. (..) - 매개 변수
    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        var name = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        logger.info("The method {}() begins with {} arguments", name, args);
    }
    // 위에서 포인트컷은 @Before("execution(* *.*(..))"), 조인 포인트는 * *.*(..), 어드바이스는 logBefore 메서드...

    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("The method {}() ends", joinPoint.getSignature().getName());
    }

    // @After와 같은데, Object 타입으로 반환값을 returning에서 받아볼 수가 있구나...
    // 순서는 @AfterReturning 다음에 @After
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("The method {}() ends with {} result", joinPoint.getSignature().getName(), result);
    }

    // throwing 속성을 통해 모든 예외와 오류의 부모 Throwable 타입(ex)을 받아온다
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        var name = joinPoint.getSignature().getName();
        logger.info("An exception {} has been thrown in {}()", ex, name);
    }

    // 특정 예외 로깅은...
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "ex")
    // 이렇게 ex 부분에 특정 예외 타입을 지정하면 된다고...
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) {
        var args = Arrays.toString(joinPoint.getArgs());
        var name = joinPoint.getSignature().getName();
        logger.info("Illegal arguments {} in {}()", args, name);
    }
}
