package com.example.Utilizadores.Utilizador;

import com.example.Utilizadores.Registo_Acessos.Registo_Acessos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UtilizadorConfig {
    @Bean
    CommandLineRunner utilizadorcommandLineRunner(UtilizadorRepository repository) {
        return args -> {
            Utilizador ppp = new Utilizador();
            repository.saveAll(List.of(ppp));
        };
    }
}
