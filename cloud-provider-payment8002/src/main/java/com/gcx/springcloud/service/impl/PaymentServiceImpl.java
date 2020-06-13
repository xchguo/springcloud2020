package com.gcx.springcloud.service.impl;

import com.gcx.springcloud.dao.PaymentDao;
import com.gcx.springcloud.entities.Payment;
import com.gcx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    // @Resource是Java自带的注解
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
