package com.example.Utilizadores.Utilizador;

import jakarta.persistence.*;

@Entity
@Table
public class Utilizador {
    @Id
    @SequenceGenerator(name = "utilizador_sequence", sequenceName = "utilizador_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilizador_sequence")
    private Long id;
    private String username ;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilizador(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Utilizador() {}

    @Override
    public String toString() {
        return "Utilizador{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
