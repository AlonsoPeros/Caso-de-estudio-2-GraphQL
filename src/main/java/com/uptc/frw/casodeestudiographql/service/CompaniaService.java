package com.uptc.frw.casodeestudiographql.service;

import com.uptc.frw.casodeestudiographql.jpa.model.Compania;
import com.uptc.frw.casodeestudiographql.jpa.repository.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniaService {
    @Autowired
    private CompaniaRepository companiaRepository;

    public List<Compania> findAllServicios() {
        return companiaRepository.findAll();
    }


    public Compania findById(Long id) {
        return companiaRepository.findById(id).orElse(null);
    }
    public Compania save(Compania compania) {
        return companiaRepository.save(compania);
    }
    public String delete(Long id) {
        Optional<Compania> compania = companiaRepository.findById(id);

        if (compania.isPresent()) {
            companiaRepository.deleteById(id);
            return "Compania eliminada con éxito";
        } else {
            return "Compania no fue encontrada";
        }
    }
    public Compania update(Long id, String actividad) {
        Optional<Compania> optionalCompania = companiaRepository.findById(id);

        if (optionalCompania.isPresent()) {
            Compania companiaOld = optionalCompania.get();
            // Solo actualiza los campos no nulos
            if (actividad != null) companiaOld.setActividad(actividad);
            return companiaRepository.save(companiaOld);
        } else {
            throw new RuntimeException("Compania con id " + id + " no encontrado.");
        }
    }
}
