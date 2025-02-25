package com.cristian.springcloud.msvc.prueba.msvc_prueba.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(targetEntity = Franquicia.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "franquicia_id" )
    @JsonBackReference
    private Franquicia franquicia;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "sucursal")
    @JsonManagedReference
    private List<Producto> productos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
}
