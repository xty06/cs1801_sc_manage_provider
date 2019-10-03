package com.qf.sc.manage.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.qf.mapper")
@ImportResource("classpath:applocationContext_dubbo.xml")
public class Cs1801ScManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cs1801ScManageServiceApplication.class, args);
    }
}
