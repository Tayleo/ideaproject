package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.example.demo.dao")
@Configuration
public class DemoApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }


}
