package com.apress.spring6recipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;

public class Sequence {

    private final AtomicInteger counter = new AtomicInteger();

    // PrefixGenerator 타입이 둘 있으니 name으로 구분
    // 여기 name은 Class 이름이 아니라 SequenceConfiguration의 Bean 메서드 이름
    @Resource(name = "datePrefixGenerator")
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

    public String nextValue() {
        return prefixGenerator.getPrefix() + (initial + counter.getAndIncrement()) + suffix;
    }
}
