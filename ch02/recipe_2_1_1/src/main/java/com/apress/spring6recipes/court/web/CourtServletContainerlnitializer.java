package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.config.CourtConfiguration;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class CourtServletContainerlnitializer implements ServletContainerInitializer {

    public static final String MSG = "Starting Court Web Application";

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        servletContext.log(MSG);

        var applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(CourtConfiguration.class);

        // 이게 핵심이라고...요청 수신 핸들러 전달...
        var dispatcherServlet = new DispatcherServlet(applicationContext);

        // 서블릿 이름은 court로 등록
        var courtRegistration = servletContext.addServlet("court", dispatcherServlet);
        // 루트 맵핑으로 모든 URL 담당 서블릿으로
        courtRegistration.addMapping("/");
        courtRegistration.setLoadOnStartup(1);
    }
}
