package com.spring.feature.mailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * This class is pre-configured to send email using gmail.
 * For your credential to work, be aware you should turn "Access to less secure apps" option off.
 */
@Configuration
public class MailSenderConfig {

    @Bean
    public JavaMailSender javaMailSenderConfiguration() {

        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.gmail.com");
        javaMailSenderImpl.setPort(587);
        javaMailSenderImpl.setUsername(""); //TODO here is your email
        javaMailSenderImpl.setPassword(""); //TODO here is your password

        Properties javaMailProperties = javaMailSenderImpl.getJavaMailProperties();
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.debug", "true");

        return javaMailSenderImpl;
    }
}
