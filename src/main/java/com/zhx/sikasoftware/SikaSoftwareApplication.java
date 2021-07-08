package com.zhx.sikasoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zhx.sikasoftware.mapper")
@SpringBootApplication
public class SikaSoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(SikaSoftwareApplication.class, args);
    }

}
