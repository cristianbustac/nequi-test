package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Producto;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories.ProductoRepository;

@Service
public class ProductoServiceimpl implements ProductoService{
    private final ProductoRepository productoRepository;

    public ProductoServiceimpl(
        ProductoRepository productoRepository
    ) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public Optional<Producto> getSucursalById(Long id) {
        return productoRepository.findById(id);
    }

    public void updateStock(long id, int stock) {
    Optional<Producto> productoOp = productoRepository.findById(id);
    if (productoOp.isPresent()) {
        Producto producto = productoOp.orElseThrow();
        producto.setStock(stock);
        productoRepository.save(producto);
    }
    }

    public void updateName(long id, String name) {
        Optional<Producto> productoOp = productoRepository.findById(id);
        if (productoOp.isPresent()) {
            Producto producto = productoOp.orElseThrow();
            producto.setNombre(name);
            productoRepository.save(producto);
        }
    }
}
