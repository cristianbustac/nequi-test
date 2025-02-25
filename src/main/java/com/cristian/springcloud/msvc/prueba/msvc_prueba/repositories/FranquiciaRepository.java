package com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Franquicia;

@Repository
public interface FranquiciaRepository extends CrudRepository<Franquicia, Long> {
}
