package com.apress.spring6recipes.calculator;

import java.lang.annotation.*;

// 1-16에서 포인트컷을 밖으로 빼 클래스로 만든 것보다 하나 더 단계를 거친다...
// 여기서는 포인트컷 이름만 만들어두고...
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggingRequired {
}
