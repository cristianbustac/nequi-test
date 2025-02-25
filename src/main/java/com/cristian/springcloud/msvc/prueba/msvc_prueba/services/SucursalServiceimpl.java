package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Producto;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Sucursal;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories.ProductoRepository;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories.SucursalRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SucursalServiceimpl implements SucursalService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public SucursalServiceimpl(
        ProductoRepository productoRepository,
        SucursalRepository sucursalRepository
    ) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<Sucursal> getAllSucursales() {
        return(List<Sucursal>) sucursalRepository.findAll();
    }

    public Optional<Sucursal> getSucursalById(Long id) {
        return sucursalRepository.findById(id);
    }

    public Sucursal createSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }

    public void AddProductotoSucursal(Long sucursalId, Long productoId) {
        Optional<Producto> productoOp = productoRepository.findById(productoId);
        Optional<Sucursal> sucursalOp = sucursalRepository.findById(sucursalId);
        if (productoOp.isPresent() && sucursalOp.isPresent()) {
            Producto producto = productoOp.orElseThrow();
            Sucursal sucursal = sucursalOp.orElseThrow();
            producto.setSucursal(sucursal);
            productoRepository.save(producto);
        }
    }

    public void RemoveProductoFromSucursal(Long sucursalId, Long productoId) {
        Optional<Producto> productoOp = productoRepository.findById(productoId);
        Optional<Sucursal> sucursalOp = sucursalRepository.findById(sucursalId);
        if (productoOp.isPresent() && sucursalOp.isPresent()) {
            Producto producto = productoOp.orElseThrow();
            producto.setSucursal(null);
            productoRepository.save(producto);
        }
    }

    public void updateName(long id, String name) {
        Optional<Sucursal> sucursalOp = sucursalRepository.findById(id);
        if (sucursalOp.isPresent()) {
            Sucursal sucursal = sucursalOp.orElseThrow();
            sucursal.setNombre(name);
            sucursalRepository.save(sucursal);
        }
    }
}
