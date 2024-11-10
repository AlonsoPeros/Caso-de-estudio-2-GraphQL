package com.uptc.frw.casodeestudiographql.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPANIA")
public class Compania {
    @Id
    @Column(name = "ID_COMPANIA",insertable=false, updatable=false)
    private long id;
    @Column(name = "ACTIVIDAD_PRINCIPAL")
    private String actividad;

    @OneToMany(mappedBy = "compania")
    private List<Soldado> soldados;
    @ManyToMany
    @JoinTable(
            name = "CUARTEL_COMPANIA",
            joinColumns = @JoinColumn(name = "ID_COMPANIA"),
            inverseJoinColumns = @JoinColumn(name = "ID_CUARTEL")
    )
    private List<Cuartel> cuarteles;

    public Compania() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<Soldado> soldados) {
        this.soldados = soldados;
    }

    public List<Cuartel> getCuarteles() {
        return cuarteles;
    }

    public void setCuarteles(List<Cuartel> cuarteles) {
        this.cuarteles = cuarteles;
    }

    @Override
    public String toString() {
        return "Compania{" +
                "id=" + id +
                ", actividad='" + actividad + '\'' +
                '}';
    }
}
