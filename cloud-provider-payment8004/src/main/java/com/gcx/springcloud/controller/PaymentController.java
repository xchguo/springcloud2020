package com.gcx.springcloud.controller;

import com.gcx.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public CommonResult paymentzk() {
        return new CommonResult("springcloud with zookeeper: " + serverPort);
    }
}
