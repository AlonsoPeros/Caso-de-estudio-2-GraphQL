package com.uptc.frw.casodeestudiographql.service;

import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.jpa.repository.CuerpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void delete(long id) {
        cuerpoRepository.deleteById(id);
    }
}
