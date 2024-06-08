package com.example.Utilizadores.Registo_Acessos;

import com.example.Utilizadores.Utilizador.Utilizador;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Registo_Acessos {
    @Id
    @SequenceGenerator(name = "registo_acessos_sequence", sequenceName = "registo_acessos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registo_acessos_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "utilizador_id", referencedColumnName = "id")
    private Utilizador utilizador;
    private LocalDateTime data;

    public Registo_Acessos() {
    }

    public Registo_Acessos(Utilizador utilizador, LocalDateTime data) {
        this.utilizador = utilizador;
        this.data = data;
    }

    public Registo_Acessos(Long id, Utilizador utilizador, LocalDateTime data) {
        this.id = id;
        this.utilizador = utilizador;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Registo_Acessos{" +
                "id=" + id +
                ", utilizador=" + utilizador +
                ", data=" + data +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
