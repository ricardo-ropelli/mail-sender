package com.spring.feature.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableAutoConfiguration
public class MailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class, args);
    }
}
