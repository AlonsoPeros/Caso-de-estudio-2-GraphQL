package com.uptc.frw.casodeestudiographql.service;


import com.uptc.frw.casodeestudiographql.jpa.model.Cuartel;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuartelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuartelService {

    @Autowired
    private  CuartelRepository cuartelRepository;

    public List<Cuartel> findAllcuartel() {
        return cuartelRepository.findAll();
    }

    public Cuartel finByIdCuartel(Long id) {
        return cuartelRepository.findById(id).orElse(null);
    }

    public Cuartel saveCuartel(Cuartel cuartel) {
        return cuartelRepository.save(cuartel);
    }
    public String deleteCuartel(Long id) {
        Optional<Cuartel> cuartel = cuartelRepository.findById(id);

        if (cuartel.isPresent()) {
            cuartelRepository.deleteById(id);
            return "Cuartel eliminado con exito";
        } else {
            return "No se puede eliminar el cuartel";
        }

    }

    public Cuartel updateCuartel(Long id, String nombre, String ubicacion ) {
        Optional<Cuartel> optionalCuartel = cuartelRepository.findById(id);

        if (optionalCuartel.isPresent()) {
            Cuartel cuartelOld = optionalCuartel.get();
            if (nombre != null || ubicacion != null) cuartelOld.setUbicacion(ubicacion);
            cuartelOld.setNombre(nombre);
            return cuartelRepository.save(cuartelOld);
        }else {
            throw new RuntimeException("No se puede eliminar el cuartel" + "del Id"+ id);

        }







    }

}
