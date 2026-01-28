package com.jesus.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class GreetinAspect {
    // Aquí irían los consejos (advices) y pointcuts para el aspecto de saludo

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void loggerBefore(JoinPoint joinPoint) {
        // Obtener información del método interceptado
        String method = joinPoint.getSignature().toShortString();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos: " + args);

    }

}
