package com.apress.spring6recipes.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @Around("execution(* *.*(..))")
    // 다른 것들과 다르게 조인포인트가 ProceedingJoinPoint 타입...
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        var name = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        logger.info("The method {} begins with {}", name, args);

        try {
            // 반드시 joinPoint.proceed()를 호출해야 넘어가고...
            var result = joinPoint.proceed();
            logger.info("The method {} ends with {}", name, result);
            // 심지어는 반환 값도 바꿀 수 있다...
            return result;
        } catch (IllegalArgumentException e) {
            logger.info("Illegal arguments {} in {}", args, name);
            throw e;
        }
        // 하지만 왜 그런지는 모르겠지만, 최소 범위의 어드바이스를 선택하는게 좋다는데...
    }
}
