package com.example.Centro_Vac.Marcacao;

import jakarta.persistence.*;

@Entity
@Table
public class Marcacao {
    @Id
    @SequenceGenerator(name = "marcacao_sequence", sequenceName = "marcacao_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marcacao_sequence")
    private Long id;
    private String utilizador;
    private String centro;

    public Marcacao(String utilizador, String centro) {
        this.utilizador = utilizador;
        this.centro = centro;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "{\"id\": \""+id+"\",\"utilizador\": \""+utilizador+"\",\"centro\":\""+centro+"\"}";
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public Marcacao() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marcacao(Long id) {
        this.id = id;
    }


//private HashMap<LocalDate, ArrayList<Utente>> agenda;
    //private CentroVac centro;
}
