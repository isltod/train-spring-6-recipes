package com.apress.spring6recipes.sequence.config;

import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration으로 구성 클래스로 등록 - 스프링에서 자동으로 찾아서 IoC 컨테이너 구성
@Configuration
public class SequenceConfiguration {

    // @Configuration 내에서 스프링이 자동으로 @Bean 찾아서 IoC 컨테이너에 Bean 등록
    @Bean
    // 아래처럼 명시적으로 이름을 줄 수도 있다고...
    // @Bean(name = "simpleSequence")
    public Sequence sequence(){
        var seqgen = new Sequence();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }
}
