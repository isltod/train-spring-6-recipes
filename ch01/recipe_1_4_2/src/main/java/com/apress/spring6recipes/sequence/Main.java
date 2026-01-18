package com.apress.spring6recipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// XML에서는 ComponentScan만 있고, @Configuration 클래스를 지우면 빈을 못찾겠다고 오류나는데...
		// 여기서 context는 XML만 읽어들이고 있고...이게 무슨 수수께끼같은 상황인지...
		// 유추하자면, XML에서 ComponentScan을 통해 @Configuration 클래스를 스캔하고,
		// 그 안의 @Bean 메서드들을 통해 빈을 등록하는 것 같다
		ApplicationContext context = new GenericXmlApplicationContext("appContext.xml");

		Sequence generator = (Sequence) context.getBean("sequenceGenerator");

		System.out.println(generator.getSequence());
		System.out.println(generator.getSequence());

		((GenericXmlApplicationContext) context).close();
	}

}
