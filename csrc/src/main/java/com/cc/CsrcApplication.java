package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.cc.mapper")
@SpringBootApplication
public class CsrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsrcApplication.class, args);
    }

}
