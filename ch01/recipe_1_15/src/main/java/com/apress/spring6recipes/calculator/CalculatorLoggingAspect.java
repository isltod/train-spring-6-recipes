package com.apress.spring6recipes.calculator;

import org.aspectj.lang.JoinPoint;
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
// 길게 implements하고 @Override 하느니 그냥 이게 낫네...
@Order(1)
public class CalculatorLoggingAspect {
// implements Ordered 는 아래 @Override getOrder와 쌍을 이뤄서 사용된다...
// public class CalculatorLoggingAspect implements Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 조인포인트라고 하지만, 결국 어떤 녀석들이 무슨 일을 하는지 전반적인 속성을 볼 수 있다...
    @Before("execution(* *.*(..))")
    public void logJoinPoint(JoinPoint joinPoint) {
        // method-execution
        logger.info("Join point kind: {}", joinPoint.getKind());
        // interface com.apress.spring6recipes.calculator.UnitCalculator
        logger.info("Signature declaration type: {}", joinPoint.getSignature().getDeclaringType());
        // kilometerToMiles
        logger.info("Signature name: {}", joinPoint.getSignature().getName());
        // [5.0]
        logger.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
        // com.apress.spring6recipes.calculator.StandardUnitCalculator
        logger.info("Target class: {}", joinPoint.getTarget().getClass().getName());
        // jdk.proxy2.$Proxy17
        logger.info("This class: {}", joinPoint.getThis().getClass().getName());
        // 이 프록시로 위에 원본 StandardUnitCalculator를 감싼다...조인포인트의 this는 프록시다...
    }

    // @Override
    // public int getOrder() {
    //     return 1;
    // }
}
