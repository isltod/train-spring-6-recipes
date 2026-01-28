package com.apress.spring6recipes.sequence;

import java.util.concurrent.ThreadLocalRandom;

public class NumberPrefixGenerator implements PrefixGenerator {

    @Override
    public String getPrefix() {
        var randomGenerator = ThreadLocalRandom.current();
        return String.format("%03d", randomGenerator.nextInt(100));
    }
}
