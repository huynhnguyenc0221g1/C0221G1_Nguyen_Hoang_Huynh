package com.book_borrowing.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDate;
import java.util.Arrays;

@Aspect
public class AopBookBorrowing {
    private static int count = 0;
    @AfterReturning(value = "execution(public * com.book_borrowing.controller.BookController.showListBook(..))")
    public void afterShowBookList(JoinPoint joinPoint){
        System.err.println("Started " + ++count+ joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(public * com.book_borrowing.controller.BookController.*(..))")
    public void controllerChangeLog(JoinPoint joinPoint){
        System.err.println("Change occurred " +joinPoint.getSignature().getName() + "at" + LocalDate.now());
    }

   @After(value = "execution(public * com.book_borrowing.controller.BookController.giveBook(..))")
    public void afterReturn(JoinPoint joinPoint){
        System.err.println("Returned book " +joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(public * com.book_borrowing.controller.BookController.borrowBook(..))",throwing = "e")
    public void borrowBook(JoinPoint joinpoint, Exception e){
        String argName = Arrays.toString(joinpoint.getArgs());
        System.err.printf("Out of book ",argName);
    }
}
