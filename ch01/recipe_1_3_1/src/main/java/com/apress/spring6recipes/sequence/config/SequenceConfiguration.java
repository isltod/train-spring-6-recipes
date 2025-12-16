package com.apress.spring6recipes.sequence.config;

import com.apress.spring6recipes.sequence.DatePrefixGenerator;
import com.apress.spring6recipes.sequence.PrefixGenerator;
import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        return new DatePrefixGenerator("yyyyMMdd");
    }

    @Bean
    public Sequence sequenceGenerator(PrefixGenerator prefixGenerator){
        var generator = new Sequence("A", 100000);
        generator.setPrefixGenerator(prefixGenerator);
        // 또는 위에서 @Bean 했으니까 표기법에 따라 아래처럼 불러올 수도...
        // generator.setPrefixGenerator(datePrefixGenerator());
        return generator;
    }
}
