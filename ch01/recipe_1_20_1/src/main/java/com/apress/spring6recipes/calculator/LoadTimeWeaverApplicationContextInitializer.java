package com.apress.spring6recipes.calculator;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.weaving.AspectJWeavingEnabler;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

/**
 * Needed to eagerly regsiter the loadtime weaving classloader in standalone scenarios
 */
public class LoadTimeWeaverApplicationContextInitializer
        implements ApplicationContextInitializer<AnnotationConfigApplicationContext> {
    @Override
    public void initialize(AnnotationConfigApplicationContext applicationContext) {
        var beanClassLoader = applicationContext.getBeanFactory().getBeanClassLoader();
        // Source - https://stackoverflow.com/a/29110861
        var ltw = new InstrumentationLoadTimeWeaver(beanClassLoader);
        AspectJWeavingEnabler.enableAspectJWeaving(ltw, beanClassLoader);
    }
}
