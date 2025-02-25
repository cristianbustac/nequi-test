package com.cristian.springcloud.msvc.prueba.msvc_prueba.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Franquicia;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.entities.Sucursal;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories.FranquiciaRepository;
import com.cristian.springcloud.msvc.prueba.msvc_prueba.repositories.SucursalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FranquiciaServiceimpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;

    public FranquiciaServiceimpl(
        FranquiciaRepository franquiciaRepository,
        SucursalRepository sucursalRepository
    ) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public List<Franquicia> getAllFranquicias() {
        return (List<Franquicia>) franquiciaRepository.findAll();
    }

    public Optional<Franquicia> getFranquiciaById(Long id) {
        return franquiciaRepository.findById(id);
    }

    @Transactional
    public Franquicia createFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Transactional
    public void deleteFranquicia(Long id) {
        franquiciaRepository.deleteById(id);
    }

    @Transactional
    public void AddSucursaltoFranquicia(long idFranquicia, long idSucursal) {
        Optional<Franquicia> franquiciaOp = franquiciaRepository.findById(idFranquicia);
        Optional<Sucursal> sucursalOp = sucursalRepository.findById(idSucursal);
        if (franquiciaOp.isPresent() && sucursalOp.isPresent()) {
            Franquicia franquicia = franquiciaOp.orElseThrow();
            Sucursal sucursal = sucursalOp.orElseThrow();
            sucursal.setFranquicia(franquicia);;
            sucursalRepository.save(sucursal);
        }
    }

    public List<Object[]> findMaxStockByFranquicia(Long idFranquicia) {
        return franquiciaRepository.findMaxStockByFranquicia(idFranquicia);
    }

    public void updateName(long id, String name) {
        Optional<Franquicia> franquiciaOp = franquiciaRepository.findById(id);
        if (franquiciaOp.isPresent()) {
            Franquicia franquicia = franquiciaOp.orElseThrow();
            franquicia.setNombre(name);
            franquiciaRepository.save(franquicia);
        }
    }
}
