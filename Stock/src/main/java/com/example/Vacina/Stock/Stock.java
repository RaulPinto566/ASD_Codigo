package com.example.Vacina.Stock;

import jakarta.persistence.*;

@Entity
@Table
public class Stock {
    @Id
    @SequenceGenerator(name = "stock_sequence", sequenceName = "stock_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_sequence")
    private Long id;
    private String centro;
    private String vacina;
    private String quantidade;

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCentro() {
        return centro;
    }
    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Stock() {
    }

    public Stock(String centro, String vacina, String quantidade) {
        this.centro = centro;
        this.vacina = vacina;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"id\": \""+id+"\",\"centro\": \""+centro+"\",\"vacina\": \""+vacina+"\",\"quantidade\": \""+quantidade+"\"}";
    }
}
