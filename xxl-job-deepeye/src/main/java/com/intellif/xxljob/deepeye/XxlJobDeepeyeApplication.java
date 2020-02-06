package com.intellif.xxljob.deepeye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.intellif.xxljob.deepeye.mapper")
public class XxlJobDeepeyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobDeepeyeApplication.class, args);
    }

}
