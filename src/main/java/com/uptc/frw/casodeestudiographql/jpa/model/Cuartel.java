package com.uptc.frw.casodeestudiographql.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CUARTEL")
public class Cuartel {
    @Id
    @Column(name = "ID_CUARTEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqCuartel")
    @SequenceGenerator(name = "seqCuartel",sequenceName = "CUARTEL_SEQ",allocationSize = 1)
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "UBICACION")
    private String ubicacion;

    @OneToMany(mappedBy="cuartel")
    private List<Soldado> soldados;

    @ManyToMany(mappedBy = "cuarteles")
    private List<Compania> companias;

    public Cuartel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<Soldado> soldados) {
        this.soldados = soldados;
    }

    public List<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(List<Compania> companias) {
        this.companias = companias;
    }

    @Override
    public String toString() {
        return "Cuartel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
