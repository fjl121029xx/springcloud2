package com.li.springcloud2.config;

import com.li.springcloud2.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {

//    @Autowired
//    private IClientConfig config;

    @Bean
    public IRule ribbonRule() {

        return new RandomRule();
    }
}
