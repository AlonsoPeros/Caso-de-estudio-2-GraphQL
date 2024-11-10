package com.uptc.frw.casodeestudiographql.jpa.model.Key;

import com.uptc.frw.casodeestudiographql.jpa.model.Servicio;
import com.uptc.frw.casodeestudiographql.jpa.model.Soldado;

public class SoldadoServicioKey {
    private Soldado soldado;
    private Servicio servicio;

    public SoldadoServicioKey() {
    }

    public Soldado getSoldado() {
        return soldado;
    }

    public void setSoldado(Soldado soldado) {
        this.soldado = soldado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
