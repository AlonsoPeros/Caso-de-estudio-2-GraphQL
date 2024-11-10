package com.uptc.frw.casodeestudiographql.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SERVICIO")
public class Servicio {
    @Id
    @Column(name = "ID_SERVICIO")
    private int id;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(mappedBy = "servicio")
    private List<SoldadoServicio> soldados;

    public Servicio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
