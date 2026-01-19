package com.apress.spring6recipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
}
