package com.uptc.frw.casodeestudiographql.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SERVICIO")
public class Servicio {
    @Id
    @Column(name = "ID_SERVICIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqServicios")
    @SequenceGenerator(name = "seqServicios",sequenceName = "SERVICIOS_SEQ",allocationSize = 1)
    private long id;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(mappedBy = "servicio")
    private List<SoldadoServicio> soldados;

    public Servicio() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SoldadoServicio> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<SoldadoServicio> soldados) {
        this.soldados = soldados;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
