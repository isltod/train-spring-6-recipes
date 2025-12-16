package com.apress.spring6recipes.sequence.config;

import com.apress.spring6recipes.sequence.PrefixGenerator;
import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 또는 여기서 아래처럼 import하고 메인에서는 기존처럼 사용할 수도 있다..
//@Import(PrefixConfiguration.class)
@Configuration
public class SequenceConfiguration {

    @Bean
    public Sequence sequence(PrefixGenerator prefixGenerator) {
        return new Sequence(prefixGenerator, "A", 100000);
    }
}
