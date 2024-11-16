package com.uptc.frw.casodeestudiographql.controller;


import com.uptc.frw.casodeestudiographql.jpa.model.Servicio;
import com.uptc.frw.casodeestudiographql.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ServicioControlador {

    @Autowired
    private ServicioService servicioService;

    @QueryMapping
    public List<Servicio> findAllServicios() {
        return servicioService.findAllServicio();
    }

    @QueryMapping
    public Servicio findServicioById(@Argument long id) {
        return servicioService.findServicioById(id);
    }

    @MutationMapping
    public Servicio createServicio(@Argument String descripcion) {
        Servicio servicio = new Servicio();
        servicio.setDescripcion(descripcion);
        return servicioService.saveServicio(servicio);
    }

    @MutationMapping
    public String deleteServicio(@Argument long id) {
        return servicioService.deleteServicio(id);
    }

    @MutationMapping
    public Servicio updateServicio(@Argument Long id, @Argument String descripcion) {
        return servicioService.updateServicio(id, descripcion);
    }

}
