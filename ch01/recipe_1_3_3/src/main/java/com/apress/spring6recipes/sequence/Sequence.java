package com.apress.spring6recipes.sequence;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;

public class Sequence {

	private final AtomicInteger counter = new AtomicInteger();

	private final String suffix;

	private final int initial;

	// DatePrefix와 NumberPrefix를 배열로 자동 삽입 - 여기서는 configuration 클래스에 Bean으로...
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
