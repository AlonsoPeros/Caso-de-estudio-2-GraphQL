package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Compania;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.service.CompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompaniaController {

    @Autowired
    private CompaniaService companiaService;

    @QueryMapping
    public List<Compania> findAllCompanias() {
        return companiaService.findAllServicios();
    }

    @QueryMapping
    public Compania findCompania(@Argument long id) {
        return companiaService.findById(id);
    }
    //Mutaciones
    @MutationMapping
    public Compania createCompania(@Argument String actividad) {
        Compania compania = new Compania();
        compania.setActividad(actividad);
        return companiaService.save(compania);
    }
    @MutationMapping
    public String deleteCompania(@Argument long id){
        return companiaService.delete(id);
    }
    @MutationMapping
    public Compania updateCompania(
            @Argument Long id,
            @Argument String actividad) {
        return companiaService.update(id, actividad);
    }
}
