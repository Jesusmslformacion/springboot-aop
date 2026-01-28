package com.jesus.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

// Implementación del servicio de saludo
@Service
public class GreetingServiceImpl implements GreetingService {

    @Override // Método para saludar a una persona con una frase dada
    public String sayHello(String person, String phrase) {
       String greeting = phrase + ", " + person + "!";
       System.out.println(greeting);
         return greeting;
    }
}