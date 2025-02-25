package com.cristian.springcloud.msvc.prueba.msvc_prueba.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.services.ProductoService;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.dto.ProductoDto;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(
        summary = "obtener todos los productos de base de datos",
        description = "muestra todos los prodcutos con su respectivo id"
    )
    public List<Producto> getAllProductos() {
        return this.productoService.getAllProductos();
    }

    @PostMapping
    @Operation(
        summary = "Crear un producto",
        description = "Agrega un nuevo producto a la base de datos."
    )
    public ResponseEntity<Producto> createProducto(@RequestBody ProductoDto ProductoDto) {
        Producto Producto = new Producto();
        Producto.setNombre(ProductoDto.getNombre());
        Producto.setStock(ProductoDto.getStock());
        Producto nuevoProducto = this.productoService.createProducto(Producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "actualiza un producto",
        description = "actualiza el campo stock en un objeto producto"
    )
    public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestParam int stock) {
        productoService.updateStock(id, stock);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/name")
    @Operation(
        summary = "actualiza un producto",
        description = "actualiza el campo name en un objeto producto"
    )
    public ResponseEntity<?>  putProductoNombre(@PathVariable long id, @RequestParam String name) {
        productoService.updateName(id, name);
        return ResponseEntity.noContent().build();
    }
}