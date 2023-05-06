package com.wom.sites.sitios;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sites")
public class Sites {

    @Id
    @SequenceGenerator(name = "sites_id_sequence", sequenceName = "sites_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sites_id_sequence")
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

    public Sites(Long id, String nombre, String codigo, String modelo, Date fecha, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.modelo = modelo;
        this.fecha = fecha;
        this.ciudad = ciudad;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
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
