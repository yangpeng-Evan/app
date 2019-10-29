package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.qf.mapper"})
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
