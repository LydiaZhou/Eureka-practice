package com.lydia.server.web;

import com.lydia.server.Model.UnknownDO;
import com.lydia.server.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    public ProducerService producerService;

    @Value("${server.port}") String serverPort;

    @GetMapping("/getPortInfo")
    public String produce() {
        return "调用服务的端口号为：" + serverPort;
    }

    @PostMapping("/echo")
    public String echo(@RequestParam("word") String word) {
        return word;
    }

    @PostMapping("/add")
    public String add(@RequestBody UnknownDO unknown) {
        return producerService.add(unknown);
    }
}
