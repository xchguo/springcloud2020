package com.gcx.springcloud.service;

import com.gcx.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    CommonResult paymentFeignTimeout();
}
