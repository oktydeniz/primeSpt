package com.facility.primeSport.configuration;

import com.facility.primeSport.demo.DemoAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.facility")
public class AppConfig {
    @Bean
    public DemoAspect demoAspect(){
        return new DemoAspect();
    }
}
