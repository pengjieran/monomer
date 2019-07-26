package com.examplecn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

@Configuration
public class CorsConfig {

    @Bean
    public CorsRegistration corsRegistration() {

        CorsRegistration corsRegistration = new CorsRegistration("/*");
        corsRegistration.allowCredentials(true).allowedHeaders("*").allowedMethods("*").allowedOrigins("*").maxAge(360000L);
        return corsRegistration;
    }
}
