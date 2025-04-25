package com.holamundo.ejemplo.holamundo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2/producto")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1, "Laptop", 1200.00));
        productos.add(new Producto(2, "Teléfono", 800.50));
        productos.add(new Producto(3, "Tablet", 350.75)); // ID cambiado a 3
    }

    @GetMapping
    public String index() {
        return "Bienvenidos al listado de productos";
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Object> buscar(@PathVariable int idProducto) {
        for(Producto producto : productos) {
            if(producto.getId() == idProducto) {
                return ResponseEntity.ok(producto);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error 404: Producto con ID " + idProducto + " no encontrado");
    }

    private static class Producto {
        private int id;
        private String nombre;
        private double precio;

        public Producto(int id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }

        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
    }
}