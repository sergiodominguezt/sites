package com.wom.sites.codigos;

import jakarta.persistence.*;

@Entity
@Table(name = "codigos")
public class Codigos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "codigos_id_sequence", sequenceName = "codigos_id_sequence", allocationSize = 1)
    private Long id;
    private Long codigo;
    private String modelo;

    public Codigos() {
    }

    public Codigos(Long id, Long codigo, String modelo) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
