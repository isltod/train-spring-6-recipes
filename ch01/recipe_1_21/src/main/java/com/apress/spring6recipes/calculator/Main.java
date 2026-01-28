package com.apress.spring6recipes.calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

// 이것도 뭘 왜하는지 이해도 되지 않고 실행도 되지 않는 코드들...
@EnableLoadTimeWeaving
public class Main {

	public static void main(String[] args) {
        var cfg = CalculatorConfiguration.class;
		try (var context = new AnnotationConfigApplicationContext(cfg)) {
			new LoadTimeWeaverApplicationContextInitializer().initialize(context);
			context.register(CalculatorConfiguration.class);
			context.refresh();

			var complexCalculator = context.getBean( ComplexCalculator.class);

			complexCalculator.add(
							new Complex(1, 2),
							new Complex(2, 3));
			complexCalculator.sub(
							new Complex(5, 8),
							new Complex(2, 3));
		}
	}
}
