package com.example.Vacina.Vue;

import jakarta.persistence.*;

@Entity
@Table
public class Vue {
    @Id
    @SequenceGenerator(name = "vue_sequence", sequenceName = "vue_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vue_sequence")
    private Long id;
    private String utilizador ;
    private String centro;
    private String marcacao;

    public Vue() {
    }

    public Vue(String utilizador, String centro, String marcacao) {
        this.utilizador = utilizador;
        this.centro = centro;
        this.marcacao = marcacao;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(String marcacao) {
        this.marcacao = marcacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vue{" +
                "id=" + id +
                ", utilizador='" + utilizador + '\'' +
                ", centro='" + centro + '\'' +
                ", marcacao='" + marcacao + '\'' +
                '}';
    }
}
