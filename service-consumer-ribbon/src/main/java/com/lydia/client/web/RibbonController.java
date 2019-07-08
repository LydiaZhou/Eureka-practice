package com.lydia.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get8085")
    public String produce8085() {
        String result = this.restTemplate.getForObject("http://service-producer:8085/getPortInfo", String.class);
        return result;
    }

    @PostMapping("/echo8085")
    public String echo8085(HttpServletRequest request, @RequestParam("word") String word) {
        HttpEntity<String> entity = new HttpEntity<>(word);
        String result = this.restTemplate.postForObject(
                "http://service-producer:8085/echo?word=" + request.getParameter("word"), entity, String.class);
        return result;
    }

    @GetMapping("/get8089")
    public String produce8089() {
        String result = this.restTemplate.getForObject("http://service-producer:8089/getPortInfo", String.class);
        return result;
    }

    @PostMapping("/add8085")
    public String add(HttpServletRequest request, @RequestBody Object o) {
        HttpEntity<Object> entity = new HttpEntity<Object>(o);
        String result = this.restTemplate.postForObject(
                "http://service-producer:8085/add", entity, String.class);
        return result;
    }
}
