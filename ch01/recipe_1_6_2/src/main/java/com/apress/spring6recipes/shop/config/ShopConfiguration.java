package com.apress.spring6recipes.shop.config;

import com.apress.spring6recipes.shop.BannerLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.apress.spring6recipes.shop")
public class ShopConfiguration {

    // 속성값을 바로 읽는 것이 아니라면, @PropertySource, PropertySourcesPlaceholderConfigurer 없이 @Value 사용
    @Value("classpath:banner.txt")
    // Resource 타입으로 선언하면 넣을 때 ResourceEditor가 자동으로 Resource 객체로 변환해 준다고...
    private Resource banner;

    @Bean
    public BannerLoader bannerLoader() {
        return new BannerLoader(banner);
    }
}
