package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.jesus.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    private void greetingLoggerPointcut() {
        // Pointcut para los métodos del servicio de saludo
    }

    @Pointcut("execution(* com.jesus.curso.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
    private void greetingFooLoggerPointcut() {
        // Pointcut para los métodos del servicio de saludo

    }

}
