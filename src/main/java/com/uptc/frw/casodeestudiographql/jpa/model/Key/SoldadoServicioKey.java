package com.uptc.frw.casodeestudiographql.jpa.model.Key;

import com.uptc.frw.casodeestudiographql.jpa.model.Servicio;
import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;

import java.io.Serializable;
import java.util.Objects;



public class SoldadoServicioKey implements Serializable {
    private long idSoldado;
    private long idServicio;

    public SoldadoServicioKey(long idSoldado, long idServicio) {
        this.idSoldado = idSoldado;
        this.idServicio = idServicio;
    }

    // Constructor vacío
    public SoldadoServicioKey() {}

    // Getters y setters
    public long getIdSoldado() {
        return idSoldado;
    }

    public void setIdSoldado(long idSoldado) {
        this.idSoldado = idSoldado;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldadoServicioKey that = (SoldadoServicioKey) o;
        return idSoldado == that.idSoldado && idServicio == that.idServicio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSoldado, idServicio);
    }
}