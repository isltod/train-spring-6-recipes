package com.apress.spring6recipes.calculator;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCounter implements Counter {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increase() {
        count.incrementAndGet();
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
