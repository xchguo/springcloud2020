package com.gcx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
自定义的ribbon负载均衡规则不能放在@CompontScan的包下
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule()
    {
        return new RandomRule(); // 随机
    }
}
