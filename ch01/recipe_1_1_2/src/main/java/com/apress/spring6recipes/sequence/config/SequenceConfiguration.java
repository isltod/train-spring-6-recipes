package com.apress.spring6recipes.sequence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan("com.apress.spring6recipes.sequence") 처럼 간단하게 해도 되지만, 조건을 넣고싶다면...
@ComponentScan(
        includeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = {
                        "com.apress.spring6recipes.sequence.*Dao",
                        "com.apress.spring6recipes.sequence.*Service"
                }
        ),
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {
                        org.springframework.stereotype.Controller.class,
                }
        )
)
public class SequenceConfiguration {
    // @ComponentScan을 넣었으니 여기서 명시적으로 @Bean을 정의하지 않아도 스프링이 찾아준다...
}
