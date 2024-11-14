package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import com.uptc.frw.casodeestudiographql.jpa.model.SoldadoServicio;
import com.uptc.frw.casodeestudiographql.service.SoldadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class SoldadoServicioController {

    @Autowired
    private SoldadoServicioService soldadoServicioService;


    @QueryMapping
    public List<SoldadoServicio> getSoldadosServicios() {
        return soldadoServicioService.getAllSoldadosServicios();
    }


    @QueryMapping
    public SoldadoServicio getSoldadoServicio(@Argument Long idSoldado, @Argument Long idServicio) {
        SoldadoServicioKey key = new SoldadoServicioKey(idSoldado,idServicio);
        return soldadoServicioService.findById(key).orElse(null);
    }


    @MutationMapping
    public SoldadoServicio createSoldadoServicio(
            @Argument Long idSoldado,
            @Argument Long idServicio,
            @Argument Date fechaServicio) {

        SoldadoServicio soldadoServicio = new SoldadoServicio();
        soldadoServicio.setIdSoldado(idSoldado);
        soldadoServicio.setIdServicio(idServicio);
        soldadoServicio.setFechaServicio(fechaServicio); // Convierte String a Date

        return soldadoServicioService.saveSoldadoServicio(soldadoServicio);
    }

    // Resolver para la mutación deleteSoldadoServicio
    @MutationMapping
    public boolean deleteSoldadoServicio(@Argument long idSoldado, @Argument long idServicio) {
        SoldadoServicioKey key = new SoldadoServicioKey(idSoldado, idServicio);
        soldadoServicioService.deleteSoldadoServicio(key);
        return true;
    }
    @MutationMapping
    public SoldadoServicio updateSoldadoServicio(
            @Argument Long idSoldado,
            @Argument Long idServicio,
            @Argument Date fechaServicio) {

        SoldadoServicioKey key = new SoldadoServicioKey(idSoldado, idServicio);
        return soldadoServicioService.update(key, fechaServicio);
    }
}
