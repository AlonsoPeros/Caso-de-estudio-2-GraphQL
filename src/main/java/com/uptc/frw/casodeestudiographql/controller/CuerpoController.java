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

@RestController
@RequestMapping("cuerpos")
@Controller
public class CuerpoController {
    @Autowired
    private CuerpoService cuerpoService;
    @GetMapping
    @QueryMapping
    public List<Cuerpo> findAll(){
        return cuerpoService.findAll();
    }
    @GetMapping("{id}")
    @QueryMapping
    public Cuerpo findById(@PathVariable @Argument long id){
        return cuerpoService.findById(id);
    }
    @PostMapping
    public Cuerpo save(@RequestBody Cuerpo cuerpo){
        return cuerpoService.save(cuerpo);
    }
    @PutMapping
    public Cuerpo update(@RequestBody Cuerpo cuerpo){
        return cuerpoService.update(cuerpo);
    }


    //Mutaciones GraphQL(nuevos metodos necesarios para que funcione con GraphQL)
    @MutationMapping
    public Cuerpo createCuerpo(@Argument String denominacion) {
        Cuerpo Cuerpo = new Cuerpo();
        Cuerpo.setDenominacion(denominacion);
        return cuerpoService.save(Cuerpo);
    }

    @DeleteMapping
    @MutationMapping
    public String deleteById(@RequestParam @Argument long id){
        return cuerpoService.delete(id);
    }

    @MutationMapping
    public Cuerpo updateCuerpo(
            @Argument Long id,
            @Argument String denominacion) {

        return cuerpoService.update(id, denominacion);
    }

}
