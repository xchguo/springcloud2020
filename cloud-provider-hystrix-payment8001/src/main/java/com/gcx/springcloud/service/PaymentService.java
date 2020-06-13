package com.gcx.springcloud.service;

public interface PaymentService {
    String paymentOk(Integer id);

    String paymentTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
