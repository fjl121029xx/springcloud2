package com.li.springcloud2;

import com.li.springcloud2.config.FooConfiguration;
import com.li.springcloud2.config.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * http://blog.csdn.net/forezp/article/details/69788938
 */
@SpringBootApplication(excludeName = "com.li.springcloud2.config")
@RibbonClient(name = "student-server", configuration = TestConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class) })
public class Springcloud2Application {

    @Autowired
    private RestTemplateBuilder builder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }

    public static void main(String[] args) {

        SpringApplication.run(Springcloud2Application.class, args);
    }
}
