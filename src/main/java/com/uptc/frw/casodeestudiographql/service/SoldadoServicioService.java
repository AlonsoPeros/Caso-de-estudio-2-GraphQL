package com.uptc.frw.casodeestudiographql.service;


import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import com.uptc.frw.casodeestudiographql.jpa.model.SoldadoServicio;
import com.uptc.frw.casodeestudiographql.jpa.repository.SoldadoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SoldadoServicioService {

    @Autowired
    private SoldadoServicioRepository soldadoServicioRepository;

    // Obtener todos los SoldadoServicio
    public List<SoldadoServicio> getAllSoldadosServicios() {
        return soldadoServicioRepository.findAll();
    }

    // Obtener un SoldadoServicio por su ID
    public Optional<SoldadoServicio> findById(SoldadoServicioKey key) {
        return soldadoServicioRepository.findById(key);
    }


    // Guardar un nuevo SoldadoServicio
    public SoldadoServicio saveSoldadoServicio(SoldadoServicio soldadoServicio) {
        return soldadoServicioRepository.save(soldadoServicio);
    }

    // Eliminar un SoldadoServicio
    public void deleteSoldadoServicio(SoldadoServicioKey id) {
        soldadoServicioRepository.deleteById(id);
    }
    public SoldadoServicio update(SoldadoServicioKey key, Date fechaServicio) {
        Optional<SoldadoServicio> soldadoServicioOpt = soldadoServicioRepository.findById(key);
        if (soldadoServicioOpt.isPresent()) {
            SoldadoServicio soldadoServicio = soldadoServicioOpt.get();
            soldadoServicio.setFechaServicio(fechaServicio);
            return soldadoServicioRepository.save(soldadoServicio);
        }
        return null;
    }
}