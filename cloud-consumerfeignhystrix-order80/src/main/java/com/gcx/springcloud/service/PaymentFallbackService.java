package com.gcx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OK的fallback方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "timeout的fallback方法";
    }
}
