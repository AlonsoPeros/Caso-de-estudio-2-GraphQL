package com.uptc.frw.casodeestudiographql.controller;

import com.uptc.frw.casodeestudiographql.jpa.model.Cuerpo;
import com.uptc.frw.casodeestudiographql.service.CuerpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cuerpos")
public class CuerpoController {
    @Autowired
    private CuerpoService cuerpoService;
    @GetMapping
    public List<Cuerpo> findAll(){
        return cuerpoService.findAll();
    }
    @GetMapping("{id}")
    public Cuerpo findById(@PathVariable long id){
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
    @DeleteMapping
    public void deleteById(@RequestParam long id){
        cuerpoService.delete(id);
    }
}
