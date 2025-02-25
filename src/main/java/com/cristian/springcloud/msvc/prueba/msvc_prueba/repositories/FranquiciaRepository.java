package com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Franquicia;

@Repository
public interface FranquiciaRepository extends CrudRepository<Franquicia, Long> {
    @Query(
        "SELECT producto.nombre, producto.stock, sucursal.nombre " +
        "FROM Producto producto " +
        "JOIN producto.sucursal sucursal " +
        "WHERE sucursal.franquicia.id = :franquiciaId " +
        "AND producto.stock = (SELECT MAX(productoInt.stock) FROM Producto productoInt WHERE productoInt.sucursal = sucursal)"
        )
    List<Object[]> findMaxStockByFranquicia(Long franquiciaId);
}
