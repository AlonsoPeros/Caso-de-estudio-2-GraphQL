package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;
import com.uptc.frw.casodeestudiographql.service.SoldadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SoldadoController {

    @Autowired
    private SoldadoService soldadoService;

    @QueryMapping
    public List<Soldado> findAllSoldados() {
        return soldadoService.findAllSoldado();
    }
    @QueryMapping
    public Soldado findSoldadoById(@Argument Long id) {
        return soldadoService.findSoldadoById(id);
    }
    @MutationMapping
    public Soldado createSoldado(@Argument String nombre, String apellido, Long grado) {
        Soldado soldado = new Soldado();
        soldado.setNombre(nombre);
        soldado.setApellido(apellido);
        soldado.setGrado(grado);
        return soldadoService.saveSoldado(soldado);


    }
    @MutationMapping
    public String deleteSoldado(@Argument long id) {
        return soldadoService.deleteSoldadoById(id);

    }
    @MutationMapping
    public Soldado updateSoldado(
            @Argument Long id,
            @Argument String nombre,
            @Argument String apellido,
            @Argument Long grado){
        return soldadoService.updateSoldadoById(id, nombre, apellido, grado);

    }

}
