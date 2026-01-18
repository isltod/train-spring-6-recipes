package com.apress.spring6recipes.sequence;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// @Component 애노테이션으로 스프링이 자동으로 빈으로 등록하도록 한다.
// @Component 보다는 더 구체적인 @Repository, @Service, @Controller 등을 사용하는 것이 좋다.
// name="sequenceDao"을 안쓰면 simpleSequenceDao가 빈 이름이 된다.
@Component("sequenceDao")
public class SimpleSequenceDao implements SequenceDao{

    private final Map<String, Sequence> sequences = new ConcurrentHashMap<>();
    private final Map<String, AtomicInteger> values = new ConcurrentHashMap<>();

    SimpleSequenceDao() {
        // 실제로는 DB에서 가져와 Sequence 도메인 객체를 생성하겠지만, 여기서는 하드코딩으로 흉내만...
        sequences.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    // 뭔가 이렇게 id를 이용해 DB에서 값을 받아서 도메인 객체를 가져오는게 DAO 패턴인듯한데, 여기서는 흉내만...
    // 결국 이 예제 getNexValue에서 Sequence 객체는 사용하질 않으니 이건 필요 없는 부분...
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
