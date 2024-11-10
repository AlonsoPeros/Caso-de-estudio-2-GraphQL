package com.uptc.frw.casodeestudiographql.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SOLDADO")
public class Soldado {
    @Id
    @Column(name = "ID_SOLDADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqSoldados")
    @SequenceGenerator(name = "seqSoldados",sequenceName = "SOLDADOS_SEQ",allocationSize = 1)
    private long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDOS")
    private String apellido;
    @Column(name = "GRADO")
    private long grado;
    @Column(name = "ID_CUERPO",insertable=false, updatable=false)
    private long idCuerpo;
    @Column(name = "ID_COMPANIA",insertable=false, updatable=false)
    private long idCompania;
    @Column(name = "ID_CUARTEL",insertable=false, updatable=false)
    private long idCuartel;

    @ManyToOne
    @JoinColumn(name = "ID_CUARTEL")
    private Cuartel cuartel;
    @ManyToOne
    @JoinColumn(name = "ID_COMPANIA")
    private Compania compania;
    @ManyToOne
    @JoinColumn(name = "ID_CUERPO")
    private Cuerpo cuerpo;
    @OneToMany(mappedBy = "soldado")
    private List<SoldadoServicio> servicios;

    public Soldado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getGrado() {
        return grado;
    }

    public void setGrado(long grado) {
        this.grado = grado;
    }

    public long getIdCuerpo() {
        return idCuerpo;
    }

    public void setIdCuerpo(long idCuerpo) {
        this.idCuerpo = idCuerpo;
    }

    public long getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(long idCompania) {
        this.idCompania = idCompania;
    }

    public long getIdCuartel() {
        return idCuartel;
    }

    public void setIdCuartel(long idCuartel) {
        this.idCuartel = idCuartel;
    }

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }

    public List<SoldadoServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<SoldadoServicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Soldado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", grado=" + grado +
                ", idCuerpo=" + idCuerpo +
                ", idCompania=" + idCompania +
                ", idCuartel=" + idCuartel +
                '}';
    }
}
