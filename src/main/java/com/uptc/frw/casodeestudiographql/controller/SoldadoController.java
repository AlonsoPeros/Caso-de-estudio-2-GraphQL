package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Compania;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuartel;
import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;
import com.uptc.frw.casodeestudiographql.service.CompaniaService;
import com.uptc.frw.casodeestudiographql.service.CuartelService;
import com.uptc.frw.casodeestudiographql.service.CuerpoService;
import com.uptc.frw.casodeestudiographql.service.SoldadoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SoldadoController {


    @Autowired
    private CompaniaService companiaService;

    @Autowired
    private CuerpoService cuerpoService;
    @Autowired
    private SoldadoService soldadoService;
    @Autowired
    private CuartelService cuartelService;

    @QueryMapping
    public List<Soldado> findAllSoldados() {
        return soldadoService.findAllSoldado();
    }

    @QueryMapping
    public Soldado findSoldadoById(@Argument Long id) {
        return soldadoService.findSoldadoById(id);
    }

    @MutationMapping
    public Soldado createSoldado(@Argument String nombre,
                                 @Argument String apellido,
                                 @Argument Long grado,
                                 @Argument Long idCuartel,
                                 @Argument Long idCompania,
                                 @Argument Long idCuerpo) {

        // Obtener las entidades relacionadas usando los IDs
        Cuartel cuartel = cuartelService.finByIdCuartel(idCuartel);
        Compania compania = companiaService.findById(idCompania);
        Cuerpo cuerpo = cuerpoService.findById(idCuerpo);

        // Crear el Soldado y asignar las relaciones
        Soldado soldado = new Soldado();
        soldado.setNombre(nombre);
        soldado.setApellido(apellido);
        soldado.setGrado(grado);
        soldado.setCuartel(cuartel);
        soldado.setCompania(compania);
        soldado.setCuerpo(cuerpo);

        return soldadoService.saveSoldado(soldado);
    }

    @MutationMapping
    public String deleteSoldado(@Argument Long id) {
        return soldadoService.deleteSoldadoById(id);
    }

    @MutationMapping
    public Soldado updateSoldado(@Argument Long id,
                                 @Argument String nombre,
                                 @Argument String apellido,
                                 @Argument Long grado) {
        return soldadoService.updateSoldado(id, nombre, apellido, grado);
    }
}
