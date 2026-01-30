package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    

    // Advice que se ejecuta antes de llamar al método sayHello
    @Before("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los parámetros: " + args);

    }

    @After("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + method + " con los parámetros: " + args);

    }

}
