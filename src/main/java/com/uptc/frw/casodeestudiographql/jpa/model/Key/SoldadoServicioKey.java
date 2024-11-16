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


    public SoldadoServicioKey() {}


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


}