package com.jeonsitalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//스프링 세큐리티를 안쓰기 때문에 exclude
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JeonsitalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeonsitalkApplication.class, args);
    }


}
