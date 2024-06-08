package com.example.Centro_Vac.Administracao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AdministracaoConfig {
    @Bean
    CommandLineRunner administracaocommandLineRunner(AdministracaoRepository repository) {
        return args -> {
            Administracao ppp = new Administracao();
            repository.saveAll(List.of(ppp));
        };
    }
}
