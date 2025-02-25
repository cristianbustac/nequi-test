package com.cristian.springcloud.msvc.prueba.msvc_prueba.dto;

public class ProductoDto {
    private String nombre;
    private Integer stock;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
