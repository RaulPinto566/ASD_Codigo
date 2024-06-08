package com.example.Centro_Vac.Centro_vac;

import jakarta.persistence.*;

@Entity
@Table
public class Centro_Vac {
    @Id
    @SequenceGenerator(name = "centro_vac_sequence", sequenceName = "centro_vac_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "centro_vac_sequence")
    private Long id;
    private String nome;
    private String localidade;
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public Centro_Vac() {
    }

    public Centro_Vac(String nome, String localidade) {
        this.nome = nome;
        this.localidade = localidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Centro_Vac(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "{\"id\": \""+id+"\",\"nome\": \""+nome+"\",\"localidade\": \""+localidade+"\"}";
    }
}
