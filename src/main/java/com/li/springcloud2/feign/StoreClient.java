package com.li.springcloud2.feign;

import com.li.springcloud2.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("student-server")
public interface StoreClient {

    @GetMapping("/student/lists")
    List<Student> getStus();
}
