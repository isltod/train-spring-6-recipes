package com.apress.spring6recipes.sequence;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component("sequenceDao")
public class SimpleSequenceDao implements SequenceDao{

    private final Map<String, Sequence> sequences = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> values = new ConcurrentHashMap<>();

    SimpleSequenceDao() {
        sequences.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    // 근데 결국 이 예제에서는 Sequence 객체는 사용하질 않으니 이건 필요 없는 부분...
    @Override
    public Sequence getSequence(String sequenceId) {
        return sequences.get(sequenceId);
    }

    @Override
    public int getNexValue(String sequenceId) {
        var value = values.get(sequenceId);
        return value.getAndIncrement();
    }
}
