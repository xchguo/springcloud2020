package com.gcx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 使用该注解赋予restTemplate负载均衡，默认轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
