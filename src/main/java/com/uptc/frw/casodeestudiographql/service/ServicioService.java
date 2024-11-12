package com.uptc.frw.casodeestudiographql.service;


import com.uptc.frw.casodeestudiographql.jpa.model.Servicio;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuartelRepository;
import com.uptc.frw.casodeestudiographql.jpa.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {


    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private CuartelRepository cuartelRepository;

    public List<Servicio> findAllServicio() {
        return servicioRepository.findAll();
    }

    public Servicio findServicioById(Long id) {
        return  servicioRepository.findById(id).orElse(null);

    }

    public Servicio saveServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public String deleteServicio(Long id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);

        if (servicio.isPresent()) {
            cuartelRepository.deleteById(id);
            return "Servicio eliminado";
        }else {
            return "El servicio no existe";
        }

    }
    public Servicio updateServicio(Long id, String descripcion) {
        Optional<Servicio> servicio = servicioRepository.findById(id);
        if (servicio.isPresent()) {
            Servicio servicioAux = servicio.get();
            if (descripcion != null) servicioAux.setDescripcion(descripcion);
            return servicioRepository.save(servicioAux);
            }else {
                throw new RuntimeException("El servicio no existe" + id);
            }


    }
}
