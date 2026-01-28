package com.apress.spring6recipes.sequence;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

// 여기에 @Component가 있거나, @Configuration에 @Bean으로 등록하면, @Autowired 동작
public class Sequence {

    private final AtomicInteger counter = new AtomicInteger();
    private final String suffix;
    private PrefixGenerator prefixGenerator = () -> "";

    public Sequence(String suffix, int initial) {
        this.suffix = suffix;
        this.counter.set(initial);
    }

    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public String nextValue() {
        return prefixGenerator.getPrefix() + (counter.getAndIncrement()) + suffix;
    }
}
