package com.apress.spring6recipes.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// @Component 같이 써줘야 찾는다 하지 않았나? 일단 @Component를 넣던말던 실행은 안된다...
@Aspect
public class ComplexCachingAspect {

    private final Map<String, Complex> cache = new ConcurrentHashMap<>();

    // 조인포인트가 new Complex(a, b)를 아래처럼 쓰는 모양...즉 새 Complex 객체 생성 타임이 조인 포인트...
    @Around("call(public com.apress.spring6recipes.calculator.Complex.new(int, int)) && args(a, b)")
    public Object cacheAround(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
        System.out.println("Around Around Around Around Around Around--------------------------------------");
        var key = a + "," + b;
        // Map의 compute는 key에 대해서 두 번째 함수를 처리하는 메서드...
        // 여기서는 값이 있으면 그 값을 그대로 쏘고, 없으면 그 키에 새 값을 저장
        return cache.compute(key, (k, v) -> checkCacheOrCalculate(joinPoint, k, v));
    }

    private Complex checkCacheOrCalculate(ProceedingJoinPoint joinPoint, String key, Complex current) {
        // key에 맞는 복소수 current가 없으면
        if (current == null) {
            try {
                System.out.println("Cache MISS for key: " + key);
                // cacheAround에서 조인포인트인 new Complex(a, b)를 호출해 새 복소수 객체를 생성하고 반환
                return (Complex) joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new IllegalStateException(throwable);
            }
        } else {
            // key에 해당하는 복소수가 있으면 바로 반환
            System.out.println("Cache HIT for key: " + key);
            return current;
        }
    }
}
