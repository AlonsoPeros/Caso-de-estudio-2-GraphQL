package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Cuartel;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.service.CuartelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CuartelController {

    @Autowired
    private CuartelService cuartelService;

    @QueryMapping
   public List<Cuartel> findAllCuartels() {
        return cuartelService.findAllcuartel();
    }

    @QueryMapping
    public Cuartel findCuartelById(@Argument long id) {
        return cuartelService.finByIdCuartel(id);
    }

    @MutationMapping
    public Cuartel createCuartel(@Argument String nombre, String ubicacion) {
        Cuartel cuartel = new Cuartel();
        cuartel.setNombre(nombre);
        cuartel.setUbicacion(ubicacion);
        return cuartelService.saveCuartel(cuartel);

    }

    @MutationMapping
    public String deleteCuartel(@Argument long id) {
        return cuartelService.deleteCuartel(id);
    }

    @MutationMapping
    public Cuartel updateCuartel(
            @Argument Long id,
            @Argument String nombre,
            @Argument String ubicacion){
        return cuartelService.updateCuartel(id, nombre, ubicacion);

    }





}
