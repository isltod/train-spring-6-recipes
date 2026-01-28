package com.apress.spring6recipes.shop;

import com.apress.spring6recipes.shop.config.ShopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Main {
    public static void main(String[] args) throws Exception {
        // 배너가 안나오는데...아래처럼 최소한 컨텍스트는 만들어야 빈이 초기화 되는거 아니냐? 이젠 나오네...
        var context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        // 이거 외에도 FileSystemResource, UrlResource 쓸 수 있다고...
        var resource = new ClassPathResource("discounts.properties");
        // @PropertySource + @Value + @Bean PropertySourcesPlaceholderConfigurer 조합대신 PropertiesLoaderUtils 사용
        var props = PropertiesLoaderUtils.loadProperties(resource);

        System.out.println("그리고, 할인 이벤트도 잊지마세요!");
        System.out.println(props);

        ((AnnotationConfigApplicationContext) context).close();
    }
}
