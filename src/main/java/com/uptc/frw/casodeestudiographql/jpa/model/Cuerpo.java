package com.uptc.frw.casodeestudiographql.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CUERPO")
public class Cuerpo {
    @Id
    @Column(name = "ID_CUERPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqCuerpos")
    @SequenceGenerator(name = "seqCuerpos",sequenceName = "CUERPOS_SEQ",allocationSize = 1)
    private long id;

    @Column(name = "DENOMINACION")
    private String denominacion;

    @OneToMany(mappedBy = "cuerpo")
    private List<Soldado> soldados;


    public Cuerpo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Soldado> getSoldados() {
        return soldados;
    }

    public void setSoldados(List<Soldado> soldados) {
        this.soldados = soldados;
    }

    @Override
    public String toString() {
        return "Cuerpo{" +
                "id=" + id +
                ", denominacion='" + denominacion + '\'' +
                '}';
    }
}
