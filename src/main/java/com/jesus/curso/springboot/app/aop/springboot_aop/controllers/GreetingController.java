package com.jesus.curso.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.curso.springboot.app.aop.springboot_aop.services.GreetingService;

// Controlador de saludos
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    @GetMapping("/greeting")
    // Simula un error al devolver un valor nulo en el campo "greeting"
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("Jesus", "Hola que tal?")));
    }

        @GetMapping("/greeting-error")
    // Simula un error al devolver un valor nulo en el campo "greeting"
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHelloError("Jesus", "Hola que tal?")));
    }

}
