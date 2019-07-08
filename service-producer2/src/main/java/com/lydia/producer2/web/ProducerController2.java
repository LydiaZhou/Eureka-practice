package com.lydia.producer2.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController2 {

    @Value("${server.port}") String serverPort;

    @GetMapping("/getPortInfo")
    public String produce() {
        return "调用服务的端口号为：" + serverPort;
    }
}
