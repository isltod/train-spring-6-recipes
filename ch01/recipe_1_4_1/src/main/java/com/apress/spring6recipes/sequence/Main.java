package com.apress.spring6recipes.sequence;

import com.apress.spring6recipes.sequence.config.SequenceConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SequenceConfiguration.class);

		Sequence generator = (Sequence) context.getBean("sequenceGenerator");

		System.out.println(generator.nextValue());
		System.out.println(generator.nextValue());
	}

}
