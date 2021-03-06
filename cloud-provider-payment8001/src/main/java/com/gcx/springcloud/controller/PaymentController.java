package com.gcx.springcloud.controller;

import com.gcx.springcloud.entities.CommonResult;
import com.gcx.springcloud.entities.Payment;
import com.gcx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
//@RequestMapping("/v1")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果为：{}", result);
        int a = 10 / 2;
        if (result > 0) {
            return new CommonResult(200, "插入成功,端口：" + port, result);
        } else {
            return new CommonResult(0, "插入失败,端口：" + port);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为：{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口：" + port, payment);
        } else {
            return new CommonResult(0, "查询失败,端口：" + port + "，id:" + id);
        }
    }

    @GetMapping("/payment/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**element**  " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return new CommonResult(this.discoveryClient);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public CommonResult paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(port);
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb()
    {
        return port;
    }
}
