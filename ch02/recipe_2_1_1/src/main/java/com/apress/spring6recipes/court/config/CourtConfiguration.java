package com.apress.spring6recipes.court.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.apress.spring6recipes.court")
// DispatcherServlet에도 뭔가 설정했는데,
// 여기서 또 추가 설정하고, WebMvcConfigurer 인스턴스를 이용해 변경할 수 있게 해준다...
// 왜 스프링부트를 쓰지 않나? 왜 이렇게 복잡하게 해야 하나...
@EnableWebMvc
public class CourtConfiguration {
}
