package com.uptc.frw.casodeestudiographql.service;

import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuerpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuerpoService {
    @Autowired
    private CuerpoRepository cuerpoRepository;

    public List<Cuerpo> findAll() {
        return cuerpoRepository.findAll();
    }
    public Cuerpo findById(Long id) {
        return cuerpoRepository.findById(id).orElse(null);
    }
    public Cuerpo save(Cuerpo cuerpo) {
        return cuerpoRepository.save(cuerpo);
    }
    public Cuerpo update(Cuerpo cuerpo) {
        Cuerpo cuerpoOld = findById(cuerpo.getId());
        cuerpoOld.setDenominacion(cuerpo.getDenominacion());
        return cuerpoRepository.save(cuerpo);
    }
    public String delete(Long id) {
        Optional<Cuerpo> departamento = cuerpoRepository.findById(id);

        if (departamento.isPresent()) {
            cuerpoRepository.deleteById(id);
            return "Cuerpo eliminado con éxito";
        } else {
            return "Cuerpo no fue encontrado";
        }
    }

    public Cuerpo update(Long id, String denominacion) {
        Optional<Cuerpo> optionalCuerpo = cuerpoRepository.findById(id);

        if (optionalCuerpo.isPresent()) {
            Cuerpo cuerpoOld = optionalCuerpo.get();
            // Solo actualiza los campos no nulos
            if (denominacion != null) cuerpoOld.setDenominacion(denominacion);
            return cuerpoRepository.save(cuerpoOld);
        } else {
            throw new RuntimeException("Cuerpo con id " + id + " no encontrado.");
        }
    }


}
