package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import java.util.List;
import java.util.Optional;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Franquicia;

public interface FranquiciaService {
    List<Franquicia> getAllFranquicias();
    Optional<Franquicia> getFranquiciaById(Long id);
    Franquicia createFranquicia(Franquicia franquicia);
    void deleteFranquicia(Long id);
    void AddSucursaltoFranquicia(long idFranquicia, long idSucursal);
    List<Object[]> findMaxStockByFranquicia(Long idFranquicia);
    void updateName(long id, String name);
}
