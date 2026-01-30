package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {
    // Aquí irían los consejos (advices) y pointcuts para el aspecto de saludo

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    // Advice que se ejecuta antes de llamar al método sayHello
    @Before("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos: " + args);

    }

    // Advice que se ejecuta después de llamar al método sayHello
    @After("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + method + " con los argumentos: " + args);

    }

    // Advice que se ejecuta después de que el método sayHello retorna exitosamente
    @AfterReturning("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de retornar: " + method + " con los argumentos: " + args);

    }

    // Advice que se ejecuta después de que el método sayHello lanza una excepción
    @AfterThrowing("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar excepción: " + method + " con los argumentos: " + args);

    }

    @Around("GreetingServicePointcuts.greetingFooLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {

            // Antes de la ejecución del método
            logger.info("Around (antes): " + method + " con los argumentos: " + args);
            result = joinPoint.proceed();
    
            // Después de la ejecución del método
            logger.info("Around (después): " + method + " con el resultado: " + result);
            return result;
        } catch (Throwable e) {
            // En caso de excepción
            logger.error("Error en el método: " + method + " con los argumentos: " + args);
            throw e;
        }

    }


}
