package com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Sucursal;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, Long> {
    List<Sucursal> findAllByFranquiciaId(Long idFranquicia);
}
