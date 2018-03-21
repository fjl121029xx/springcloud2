package com.li.springcloud2.controller;

import com.li.springcloud2.feign.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private StoreClient storeClient;

    @GetMapping("/student/lists2")
    @ResponseBody
    public Object lists() {
        System.out.println("Hello Eureka ribbon");
        return this.restTemplate.getForObject("http://student-server/student/lists", Object.class);
    }

    @GetMapping("/student/listsFeign")
    @ResponseBody
    public Object listsFeign() {
        System.out.println("Hello Feign");
        return this.storeClient.getStus();
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {

        ServiceInstance choose = this.loadBalancerClient.choose("student-server");
        System.out.println(choose.getHost() + ":" + choose.getPort() + ":" + choose.getServiceId());
        return "student-server  ";
    }
}
