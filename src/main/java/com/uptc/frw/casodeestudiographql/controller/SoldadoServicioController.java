package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import com.uptc.frw.casodeestudiographql.jpa.model.SoldadoServicio;
import com.uptc.frw.casodeestudiographql.service.SoldadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SoldadoServicioController {

    @Autowired
    private SoldadoServicioService soldadoServicioService;

    // Resolver para la consulta getSoldadosServicios
    @QueryMapping
    public List<SoldadoServicio> getSoldadosServicios() {
        return soldadoServicioService.getAllSoldadosServicios();
    }

    // Resolver para la consulta getSoldadoServicio
    @QueryMapping
    public SoldadoServicio getSoldadoServicio(@Argument Long idSoldado, @Argument Long idServicio) {
        SoldadoServicioKey key = new SoldadoServicioKey(idSoldado,idServicio);
        return soldadoServicioService.getSoldadoServicio(key).orElse(null);
    }

    // Resolver para la mutación createSoldadoServicio
    @MutationMapping
    public SoldadoServicio createSoldadoServicio(@Argument long idSoldado, @Argument long idServicio) {
        SoldadoServicio soldadoServicio = new SoldadoServicio();
        soldadoServicio.setIdSoldado(idSoldado);
        soldadoServicio.setIdServicio(idServicio);


        return soldadoServicioService.saveSoldadoServicio(soldadoServicio);
    }

    // Resolver para la mutación deleteSoldadoServicio
    @MutationMapping
    public boolean deleteSoldadoServicio(@Argument long idSoldado, @Argument long idServicio) {
        SoldadoServicioKey key = new SoldadoServicioKey(idSoldado, idServicio);
        soldadoServicioService.deleteSoldadoServicio(key);
        return true;
    }
}
