package com.why.plant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.why.plant")
@MapperScan(basePackages = "com.why.plant.dao")
public class PlantApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantApplication.class, args);
    }

}
