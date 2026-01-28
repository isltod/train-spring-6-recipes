package com.apress.spring6recipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

public class Sequence {

	private final AtomicInteger counter = new AtomicInteger();

	private final String suffix;

	private final int initial;

	// @Configuration에서 DatePrefix와 NumberPrefix로 이름도 다 다른데 
	// 같은 prefixGenerator 타입이라고 다 불러와서 배열로 자동 삽입
	@Autowired
	private PrefixGenerator[] prefixGenerators;

	public Sequence(String suffix, int initial) {
		this.suffix = suffix;
		this.initial = initial;
	}

	public String getSequence() {
		var builder = new StringBuilder();
		for (var prefix : prefixGenerators) {
			builder.append(prefix.getPrefix());
			builder.append('-');
		}
		builder.append(initial + counter.getAndIncrement()).append(suffix);
		return builder.toString();
	}

}
