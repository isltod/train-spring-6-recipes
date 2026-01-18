package com.apress.spring6recipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;

// 이건 단순 자바 클래스 POJO, 스프링 의존성 없고, @Configuration에서 Bean으로 등록해서 사용
public class Sequence {
    private final AtomicInteger counter = new AtomicInteger();
    private String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.counter.set(initial);
    }

    public String nextValue(){
        return prefix + counter.getAndIncrement() + suffix;
    }
}
