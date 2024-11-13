package com.uptc.frw.casodeestudiographql.jpa.model;

import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
@Entity
@Table(name = "SOLDADO_SERVICIO")
@IdClass(SoldadoServicioKey.class)
public class SoldadoServicio {

    @Id
    @Column(name = "ID_SOLDADO", insertable = false, updatable = false)
    private long idSoldado;

    @Id
    @Column(name = "ID_SERVICIO", insertable = false, updatable = false)
    private long idServicio;

    @Column(name = "FECHA")
    private Date fechaServicio;

    @ManyToOne
    @JoinColumn(name = "ID_SOLDADO", insertable = false, updatable = false)
    private Soldado soldado;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO", insertable = false, updatable = false)
    private Servicio servicio;

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

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
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