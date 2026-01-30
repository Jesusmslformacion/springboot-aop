package com.jesus.curso.springboot.app.aop.springboot_aop.services;

// Servicio de saludo
public interface GreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
