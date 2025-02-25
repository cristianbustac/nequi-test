package com.cristian.springcloud.msvc.prueba.msvc_prueba.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.dto.SucursalDto;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Sucursal;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.services.SucursalService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;




@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping
    @Operation(
        summary = "obtener todas las sucursales de base de datos",
        description = "muestra todas las sucursales con su respectivo id"
    )
    public List<Sucursal> getAllSucursal() {
        return this.sucursalService.getAllSucursales();
    }

    @PostMapping
    @Operation(
        summary = "Crear una sucursal",
        description = "Agrega una nueva sucursal a la base de datos."
    )
    public ResponseEntity<Sucursal> createSucursal(@RequestBody SucursalDto sucursalDto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalDto.getNombre());
        Sucursal nuevaSucursal = this.sucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(nuevaSucursal, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/product/{id_product}")
    @Operation(
        summary = "agrega un objeto producto a la sucursal",
        description = "actualiza el campo productos en un objeto sucursal"
    )
    public ResponseEntity<Sucursal> AddProductotoSucursal(@PathVariable long id, @PathVariable long id_product) {
        sucursalService.AddProductotoSucursal(id, id_product);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}/product/{id_product}")
    @Operation(
        summary = "elimina un objeto producto a la sucursal",
        description = "elimina el objeto del campo productos en un objeto sucursal"
    )
    public ResponseEntity<?> RemoveProductoFromSucursal(@PathVariable Long id, @PathVariable Long id_product) {
        sucursalService.RemoveProductoFromSucursal(id, id_product);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/name")
    @Operation(
        summary = "actualiza una sucursal",
        description = "actualiza el campo name en un objeto sucursal"
    )
    public ResponseEntity<?> putSucursalNombre(@PathVariable long id, @RequestParam String name) {
        sucursalService.updateName(id, name);
        return ResponseEntity.noContent().build();
    }
}
