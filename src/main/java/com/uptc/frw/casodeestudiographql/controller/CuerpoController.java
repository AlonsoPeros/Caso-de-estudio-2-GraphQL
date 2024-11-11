package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.service.CuerpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CuerpoController {
    @Autowired
    private CuerpoService cuerpoService;
    //Query
    @QueryMapping
    public List<Cuerpo> findAllCuerpos(){
        return cuerpoService.findAll();
    }
    @QueryMapping
    public Cuerpo findCuerpo(@Argument long id){
        return cuerpoService.findById(id);
    }
    //Mutaciones
    @MutationMapping
    public Cuerpo createCuerpo(@Argument String denominacion) {
        Cuerpo cuerpo = new Cuerpo();
        cuerpo.setDenominacion(denominacion);
        return cuerpoService.save(cuerpo);
    }
    @MutationMapping
    public String deleteCuerpo(@Argument long id){
        return cuerpoService.delete(id);
    }
    @MutationMapping
    public Cuerpo updateCuerpo(
            @Argument Long id,
            @Argument String denominacion) {
        return cuerpoService.update(id, denominacion);
    }

}
