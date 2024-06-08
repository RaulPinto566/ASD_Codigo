package com.example.Centro_Vac.Administracao;

import jakarta.persistence.*;

@Entity
@Table
public class Administracao {
    @Id
    @SequenceGenerator(name = "administracao_sequence", sequenceName = "administracao_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administracao_sequence")
    private Long id;
    private String efeitos;
    //private Vacinas vacinas;
    //private Utente utente;
//    public Administracao (String efeitos, Vacinas vacina, Utente utente)
//    {
//        this.efeitos = efeitos;
//        this.vacinas = vacina;
//        this.utente = utente;
//    }
//    public Utente get_Utente()
//    {
//        return utente;
//    }

//    public String get_TipoVacina()
//    {
//        return vacinas.get_Tipo();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEfeitos() {
        return efeitos;
    }

    public void setEfeitos(String efeitos) {
        this.efeitos = efeitos;
    }

    public Administracao(Long id, String efeitos) {
        this.id = id;
        this.efeitos = efeitos;
    }

    public Administracao() {
    }

    @Override
    public String toString() {
        return "Administracao{" +
                "id=" + id +
                ", efeitos='" + efeitos + '\'' +
                '}';
    }
}
