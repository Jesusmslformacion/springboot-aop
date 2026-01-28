package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
    // Aquí irían los consejos (advices) y pointcuts para el aspecto de saludo

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))")// Pointcut para interceptar el método sayHello del servicio de saludo
    public void loggerBefore(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos: " + args);

    }

}
