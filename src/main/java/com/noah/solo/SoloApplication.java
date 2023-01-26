package com.noah.solo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@Configuration
@SpringBootApplication
public class SoloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloApplication.class, args);
        ///sss
    }
}
