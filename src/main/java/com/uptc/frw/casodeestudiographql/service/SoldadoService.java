package com.uptc.frw.casodeestudiographql.service;

import com.uptc.frw.casodeestudiographql.jpa.model.Compania;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuartel;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;
import com.uptc.frw.casodeestudiographql.jpa.repository.CompaniaRepository;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuartelRepository;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuerpoRepository;
import com.uptc.frw.casodeestudiographql.jpa.repository.SoldadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldadoService {
    @Autowired
    private SoldadoRepository soldadoRepository;

    @Autowired
    private CuartelService cuartelService;

    @Autowired
    private CompaniaService companiaService;

    @Autowired
    private CuerpoService cuerpoService;

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
            return "No se encontró el soldado";
        }
    }

    public Soldado updateSoldado(Long id, String nombre, String apellido, Long grado) {
        Optional<Soldado> soldado = soldadoRepository.findById(id);
        if (soldado.isPresent()) {
            Soldado soldadoExistente = soldado.get();
            if (nombre != null) soldadoExistente.setNombre(nombre);
            if (apellido != null) soldadoExistente.setApellido(apellido);
            if (grado != null) soldadoExistente.setGrado(grado);
            return soldadoRepository.save(soldadoExistente);
        } else {
            throw new RuntimeException("No se encontró el soldado con id: " + id);
        }
    }
}