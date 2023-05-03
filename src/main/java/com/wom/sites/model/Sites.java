package com.wom.sites.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sites")
public class Sites {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "ciudad")
    private String ciudad;

    public Sites() {
    }

    public Sites(String nombre, String codigo, String modelo, Date fecha, String ciudad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modelo = modelo;
        this.fecha = fecha;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
