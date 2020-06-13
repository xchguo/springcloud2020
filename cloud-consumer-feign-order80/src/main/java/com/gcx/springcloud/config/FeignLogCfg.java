package com.gcx.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogCfg {
    @Bean
    Logger.Level feignLog()
    {
        return Logger.Level.FULL;
    }
}
