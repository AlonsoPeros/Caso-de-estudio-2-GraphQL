package com.uptc.frw.casodeestudiographql.jpa.model;

import com.uptc.frw.casodeestudiographql.jpa.model.Key.SoldadoServicioKey;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
@Entity
@Table(name = "SOLDADO_SERVICIO")
@IdClass(SoldadoServicioKey.class)
public class SoldadoServicio {
    @Column(name = "ID_SOLDADO",insertable=false, updatable=false)
    private long idSoldado;
    @Column(name = "ID_SERVICIO",insertable=false, updatable=false)
    private long idServicio;
    @Column(name = "FECHA")
    private Date fechaServicio;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SOLDADO")
    private Soldado soldado;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO")
    private Servicio servicio;

    public SoldadoServicio() {
    }

    public long getIdSoldado() {
        return idSoldado;
    }

    public void setIdSoldado(long idSoldado) {
        this.idSoldado = idSoldado;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
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

    @Override
    public String toString() {
        return "SoldadoServicio{" +
                "idSoldado=" + idSoldado +
                ", idServicio=" + idServicio +
                ", fechaServicio=" + fechaServicio +
                '}';
    }
}
