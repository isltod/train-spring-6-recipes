package com.apress.spring6recipes.sequence.config;

import com.apress.spring6recipes.sequence.DatePrefixGenerator;
import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SequenceConfiguration {

    @Bean
    // 이렇게 하면 무조건 datePrefixGenerator 먼저 만들고 이걸 만들어서 의존성 오류를 없앤다...
    @DependsOn("datePrefixGenerator")
    public Sequence sequenceGenerator() {
        return new Sequence("A", 100000);
    }

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        return new DatePrefixGenerator();
    }
}
