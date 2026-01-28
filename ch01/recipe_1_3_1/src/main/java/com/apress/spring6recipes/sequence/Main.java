package com.apress.spring6recipes.sequence;

import com.apress.spring6recipes.sequence.config.SequenceConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		// Sequence generator = new Sequence(null, 0)
		// 여기서 위처럼 하드코딩으로 생성하는 것이 아니라 ApplicationContext에서 가져온다..스프링 방식...
		try (var context = new AnnotationConfigApplicationContext(SequenceConfiguration.class)) {

			var generator = context.getBean(Sequence.class);

			System.out.println(generator.getSequence());
			System.out.println(generator.getSequence());
		}
	}

}
