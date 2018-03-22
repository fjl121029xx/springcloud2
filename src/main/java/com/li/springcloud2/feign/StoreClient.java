package com.li.springcloud2.feign;

import com.li.springcloud2.config.Configuration1;
import com.li.springcloud2.entity.Student;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "student-server",configuration = Configuration1.class)
public interface StoreClient {
    /**
     * 13 4.9 之前
     */
    /*@GetMapping("/student/lists")
    List<Student> getStus();*/

    @RequestLine("GET /student/lists")
    List<Student> getStus();
}
