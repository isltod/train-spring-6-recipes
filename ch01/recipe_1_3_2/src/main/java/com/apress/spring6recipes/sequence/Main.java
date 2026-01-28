package com.apress.spring6recipes.sequence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (var context = 
				new AnnotationConfigApplicationContext("com.apress.spring6recipes.sequence")) {

			// SequenceDao 빈도 @Autowired 스캔돼서 자동으로 들어감
			var sequenceService = context.getBean(SequenceService.class);
			System.out.println(sequenceService.generate("IT"));
			System.out.println(sequenceService.generate("IT"));
		}
	}
}
