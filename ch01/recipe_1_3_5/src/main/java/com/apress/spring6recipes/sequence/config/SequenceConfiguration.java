package com.apress.spring6recipes.sequence.config;

import com.apress.spring6recipes.sequence.DatePrefixGenerator;
import com.apress.spring6recipes.sequence.NumberPrefixGenerator;
import com.apress.spring6recipes.sequence.PrefixGenerator;
import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.apress.spring6recipes.sequence")
public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        var dpg = new DatePrefixGenerator();
        dpg.setPatter("yyyy-MM-dd");
        return dpg;
    }

    @Bean
    public NumberPrefixGenerator numberPrefixGenerator() {
        return new NumberPrefixGenerator();
    }

    @Bean
    public Sequence sequence(@Qualifier("datePrefixGenerator")PrefixGenerator prefixGenerator) {
        return new Sequence(prefixGenerator, "A", 100000);
    }
}
