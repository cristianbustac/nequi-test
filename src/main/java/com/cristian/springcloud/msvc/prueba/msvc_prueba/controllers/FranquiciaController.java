package com.cristian.springcloud.msvc.prueba.msvc_prueba.controllers;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.dto.FranquiciaDto;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Franquicia;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.services.FranquiciaService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
// import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/franquicia")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @GetMapping("")
    @Operation(
        summary = "obtener todas las franquicias de base de datos",
        description = "muestra todas las franquicias con su respectivo id"
    )
    public List<Franquicia> getAllFranquicias() {
        return this.franquiciaService.getAllFranquicias();
    }
    
    @PostMapping
    @Operation(
        summary = "Crear una franquicia",
        description = "Agrega una nueva franquicia a la base de datos."
    )
    public ResponseEntity<Franquicia> createFranquicia(@RequestBody FranquiciaDto franquiciaDto) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(franquiciaDto.getNombre());
        Franquicia nuevaFranquicia = franquiciaService.createFranquicia(franquicia);
        return new ResponseEntity<>(nuevaFranquicia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/sucursal/{id_sucursal}")
    @Operation(
        summary = "agrega un objeto sucursal a la franquicia",
        description = "actualiza el campo sucursales en un objeto franquicia"
    )
    public ResponseEntity<?> AddSucursaltoFranquicia(@PathVariable long id, @PathVariable long id_sucursal) {
        this.franquiciaService.AddSucursaltoFranquicia(id, id_sucursal);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/stock")
    @Operation(
        summary = "agrega un objeto sucursal a la franquicia",
        description = "muestra cual es el producto que más stock tiene por sucursal para una franquicia puntual."
    )
    public List<Object[]> getStockBySucursalByFranquicia(@RequestParam long id) {
        return this.franquiciaService.findMaxStockByFranquicia(id);
    }

    @PutMapping("/{id}/name")
    @Operation(
        summary = "actualiza una franquicia",
        description = "actualiza el campo name en un objeto franquicia"
    )
    public ResponseEntity<?>  putFranquiciaNombre(@PathVariable long id, @RequestParam String name) {
        franquiciaService.updateName(id, name);
        return ResponseEntity.noContent().build();
    }
}
