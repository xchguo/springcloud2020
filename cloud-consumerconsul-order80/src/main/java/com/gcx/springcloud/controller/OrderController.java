package com.gcx.springcloud.controller;

import com.gcx.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    private static final String URL = "http://consul-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public CommonResult getZk() {
        return restTemplate.getForObject(URL+"/payment/consul", CommonResult.class);
    }
}
