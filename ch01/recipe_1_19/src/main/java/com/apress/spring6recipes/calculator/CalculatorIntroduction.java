package com.apress.spring6recipes.calculator;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

// 인트로덕션 클래스라는 건 기존의 AOP 클래스처럼 만드는 것...
@Aspect
@Component
public class CalculatorIntroduction {

    // 사용될 메서드들을 속성처럼 설정해놓고 사용한다...
    @DeclareParents(
            value = "com.apress.spring6recipes.calculator.StandardArithmeticCalculator",
            defaultImpl = SimpleMaxCalculator.class
    )
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "com.apress.spring6recipes.calculator.StandardArithmeticCalculator",
            defaultImpl = SimpleMinCalculator.class
    )
    public MinCalculator minCalculator;

    // 클래스 이름에 와일드카드 사용...
    @DeclareParents(
            value = "com.apress.spring6recipes.calculator.Standard*Calculator",
            defaultImpl = SimpleCounter.class
    )
    public Counter counter;

    // 호출한 후에 횟수 증가 로직을 그냥 여기서 작성...
    // *Calculator 클래스의 모든 메서드 실행 -> 프록시(이 클래스)의 counter -> SimpleCounter의 increase 호출로 전달...
    @After("execution(* com.apress.spring6recipes.calculator.*Calculator.*(..)) && this(counter)")
    // 매개변수로 카운터 인터페이스 전달?
    public void increaseCounter(Counter counter) {
        counter.increase();
    }
}
