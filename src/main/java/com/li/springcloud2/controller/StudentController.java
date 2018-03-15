package com.li.springcloud2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class StudentController {
    @Autowired
    private RestTemplateBuilder builder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student/lists2")
    @ResponseBody
    public Object lists() {


        return this.restTemplate.getForObject("http://10.0.0.11:9999/student/lists", Object.class);
    }
}
