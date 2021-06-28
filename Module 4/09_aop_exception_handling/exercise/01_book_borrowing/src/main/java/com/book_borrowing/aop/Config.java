package com.book_borrowing.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public AopBookBorrowing config() {
        return new AopBookBorrowing();
    }
}
