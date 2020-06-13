package com.gcx.springcloud.controller;

import com.gcx.springcloud.entities.CommonResult;
import com.gcx.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public CommonResult paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
