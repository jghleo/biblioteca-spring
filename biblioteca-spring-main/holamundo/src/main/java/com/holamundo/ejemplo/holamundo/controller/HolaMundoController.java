package com.holamundo.ejemplo.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HolaMundoController {

    @GetMapping("/suma/{a}/{b}")
    public String suma(
            @PathVariable int a,
            @PathVariable int b) {
        int resultado = a + b;
        return String.format("Resultado de %d + %d = %d ", a, b, resultado);
    }

    @GetMapping("/resta/{a}/{b}")
    public String resta(
            @PathVariable int a,
            @PathVariable int b) {
        int resultado = a - b;
        return String.format("Resultado de %d - %d = %d ", a, b, resultado);
    }

    @GetMapping("/multiplicacion/{a}/{b}")
    public String multiplicacion(
            @PathVariable int a,
            @PathVariable int b) {
        int resultado = a * b;
        return String.format("Resultado de %d * %d = %d ", a, b, resultado);
    }


    @GetMapping("/division/{a}/{b}")
    public String division(
            @PathVariable int a,
            @PathVariable int b) {
        int resultado = a / b;
        return String.format("Resultado de %d / %d = %d ", a, b, resultado);
        }
    }

