package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import java.util.List;
import java.util.Optional;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Sucursal;

public interface SucursalService {
    List<Sucursal> getAllSucursales();
    Optional<Sucursal> getSucursalById(Long id);
    Sucursal createSucursal(Sucursal sucursal);
    void deleteSucursal(Long id);
    void AddProductotoSucursal(Long sucursalId, Long productoId);
    void RemoveProductoFromSucursal(Long sucursalId, Long productoId);
    void updateName(long id, String name);
}
