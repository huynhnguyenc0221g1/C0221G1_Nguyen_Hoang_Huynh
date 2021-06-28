package com.book_borrowing.aop.config;

import com.book_borrowing.aop.AopBookBorrowing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AOPConfig {
    @Bean
    public AopBookBorrowing config(){
        return new AopBookBorrowing();
    }
}
