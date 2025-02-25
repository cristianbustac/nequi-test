package com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
