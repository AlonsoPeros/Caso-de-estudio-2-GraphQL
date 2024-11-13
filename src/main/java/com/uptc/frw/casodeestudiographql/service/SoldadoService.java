package com.uptc.frw.casodeestudiographql.service;

import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;
import com.uptc.frw.casodeestudiographql.jpa.repository.SoldadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldadoService {
    @Autowired
    private SoldadoRepository soldadoRepository;

    public List<Soldado> findAllSoldado() {
        return soldadoRepository.findAll();
    }

    public Soldado findSoldadoById(Long id) {
        return soldadoRepository.findById(id).orElse(null);

    }
    public Soldado saveSoldado(Soldado soldado) {
        return soldadoRepository.save(soldado);
    }
    public String deleteSoldadoById(Long id) {
        Optional<Soldado> soldado = soldadoRepository.findById(id);

        if (soldado.isPresent()) {
            soldadoRepository.deleteById(id);
            return "Soldado eliminado";
        } else {
            return "No se encontro el soldado";
        }
    }
    public Soldado updateSoldadoById(Long id,String nombre, String apellido, Long grado) {
        Optional<Soldado> soldado = soldadoRepository.findById(id);

        if (soldado.isPresent()) {
            Soldado soldadoOld = soldado.get();
            if (nombre != null || apellido != null || grado != null) soldadoOld.setNombre(nombre);soldadoOld.setApellido(apellido);soldadoOld.setGrado(grado);
            return  soldadoRepository.save(soldadoOld);
        } else {
            throw new RuntimeException("No se encontro el soldado"+ id);
        }
    }

}
