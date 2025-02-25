package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import java.util.List;
import java.util.Optional;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto createProducto(Producto producto);
    void deleteProducto(Long id);
    Optional<Producto> getProductoById(Long id);
    void updateStock(long id, int stock);
    void updateName(long id, String name);
}
