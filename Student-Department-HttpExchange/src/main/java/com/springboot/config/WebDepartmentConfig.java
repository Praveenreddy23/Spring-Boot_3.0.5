package com.springboot.config;

import com.springboot.service.StudentDepartmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebDepartmentConfig {

    @Bean
    public WebClient studentServiceWebClient(){
        return WebClient
                .builder()
                .baseUrl("http://localhost:8091")
                .build();
    }

    @Bean
    public StudentDepartmentService studentDepartmentService(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builder(WebClientAdapter.forClient(studentServiceWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(StudentDepartmentService.class);
    }
}
