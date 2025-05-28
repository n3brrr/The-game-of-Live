package com.ruben.juego.gameoflife;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "Servidor Spring Boot activo 😎";
    }
}

