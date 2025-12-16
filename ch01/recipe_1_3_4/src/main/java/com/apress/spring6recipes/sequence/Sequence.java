package com.apress.spring6recipes.sequence;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {

    private final AtomicInteger counter = new AtomicInteger();
    private final String suffix;
    private final int initial;
    private PrefixGenerator prefixGenerator;

    public Sequence(String suffix, int initial, PrefixGenerator prefixGenerator) {
        this.suffix = suffix;
        this.initial = initial;
        this.prefixGenerator = prefixGenerator;
    }

    //@Autowired
    // 없어도 예외 발생 없이...
    //@Autowired(required = false)
    //public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
    //    this.prefixGenerator = prefixGenerator;
    //}

    // 또는 비슷하게 Optional
    //@Autowired
    //public void setPrefixGenerator(Optional<PrefixGenerator> prefixGenerator) {
    //    this.prefixGenerator = prefixGenerator.orElse(null);
    //}

    // 또는 비슷하게 스프링 ObjectProvider 이용 - getIfUnique 있으면 반환, 없으면 null
    public void setPrefixGenerator(ObjectProvider<PrefixGenerator> prefixGenerator) {
        this.prefixGenerator = prefixGenerator.getIfUnique();
    }

    public String nextValue() {
        return prefixGenerator.getPrefix() + (initial +  counter.getAndIncrement()) + suffix;
    }
}
