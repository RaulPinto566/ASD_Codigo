package com.example.Vacina.Vacina;

import jakarta.persistence.*;

@Entity
@Table
public class Vacinas {
    @Id
    @SequenceGenerator(name = "vacinas_sequence", sequenceName = "vacinas_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacinas_sequence")
    private Long id;
    private String tipo;
    private String nome;
    private String quantidade;

    public Vacinas(String tipo, String quantidade, String nome) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.nome = nome;
    }

    public Vacinas() {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
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
        return "Vacinas{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }
}
