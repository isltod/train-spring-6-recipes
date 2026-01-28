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
    public Sequence sequence(PrefixGenerator prefixGenerator) {
        Sequence sequence = new Sequence("A", 100000);
        // prefixGenerator는 @Autowired 세터로 주입되므로 아래 코드는 불필요
        // sequence.setPrefixGenerator(prefixGenerator);
        // 결국 생성자든 세터든 다 자동으로 된다는 얘기...
        return sequence;
    }
}
