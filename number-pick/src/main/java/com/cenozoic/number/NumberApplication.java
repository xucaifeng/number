package com.cenozoic.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
//@EnableEurekaClient
@EnableAsync
@SpringBootApplication
public class NumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberApplication.class, args);
    }

}
