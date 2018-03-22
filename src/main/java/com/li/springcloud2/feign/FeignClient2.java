package com.li.springcloud2.feign;

import com.li.springcloud2.config.Configuration2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "xxx", url = "http://localhost:9093", configuration = Configuration2.class)
public interface FeignClient2 {

    /*@RequestMapping(value = "/eureka/apps/{servicename}/",method = RequestMethod.GET)
    public String findEurekaInfoByServiceName2(@PathVariable("servicename") String servicename);*/

    @RequestLine("GET /eureka/apps/{servicename}")
    public String findEurekaInfoByServiceName(@Param("servicename") String servicename);
}
