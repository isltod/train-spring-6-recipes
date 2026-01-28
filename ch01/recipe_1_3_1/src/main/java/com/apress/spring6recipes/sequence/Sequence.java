package com.apress.spring6recipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {

	private final AtomicInteger counter = new AtomicInteger();
	private final String suffix;

	// prefixGenerator 속성은 빈 문자열을 반환하는 함수라는 얘긴가...
	// 일단 인터페이스에 문자열 반환 함수가 정의되어 있으니...
	private PrefixGenerator prefixGenerator = () -> "";

	public Sequence(String suffix, int initial) {
		this.suffix = suffix;
		this.counter.set(initial);
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public String getSequence() {
		return prefixGenerator.getPrefix() + counter.getAndIncrement() + suffix;
	}
} 