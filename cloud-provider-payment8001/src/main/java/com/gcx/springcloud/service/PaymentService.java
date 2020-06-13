package com.gcx.springcloud.service;

import com.gcx.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
