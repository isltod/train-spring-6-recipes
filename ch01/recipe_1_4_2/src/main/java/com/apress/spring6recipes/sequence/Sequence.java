package com.apress.spring6recipes.sequence;

import jakarta.inject.Inject;

import java.util.concurrent.atomic.AtomicLong;

public class Sequence {

    private final AtomicLong counter = new AtomicLong();

    // PrefixGenerator 타입이 2개 있으니 그냥 Inject하면 예외...
    // 그래서 커스텀 annotation을 만든다고...복잡하네...
    @Inject
    @DatePrefixAnnotation
    private PrefixGenerator prefixGenerator;
    private String suffix;
    private int initial;

    public Sequence() {
    }

    public Sequence(PrefixGenerator prefixGenerator, String suffix, int initial) {
        this.prefixGenerator = prefixGenerator;
        this.suffix = suffix;
        this.initial = initial;
    }

    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence() {
        return prefixGenerator.getPrefix() + (initial + counter.incrementAndGet()) +  suffix;
    }
}
