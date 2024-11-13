package com.uptc.frw.casodeestudiographql.service;


import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import com.uptc.frw.casodeestudiographql.jpa.model.SoldadoServicio;
import com.uptc.frw.casodeestudiographql.jpa.repository.SoldadoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<SoldadoServicio> getSoldadoServicio(SoldadoServicioKey id) {
        return soldadoServicioRepository.findById(id);
    }

    // Guardar un nuevo SoldadoServicio
    public SoldadoServicio saveSoldadoServicio(SoldadoServicio soldadoServicio) {
        return soldadoServicioRepository.save(soldadoServicio);
    }

    // Eliminar un SoldadoServicio
    public void deleteSoldadoServicio(SoldadoServicioKey id) {
        soldadoServicioRepository.deleteById(id);
    }
}