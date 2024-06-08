package com.example.Utilizadores.Registo_Acessos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Registo_AcessosConfig {
    @Bean
    CommandLineRunner regist_acessoscommandLineRunner(Registo_AcessosRepository repository) {
        return args -> {
            Registo_Acessos ppp = new Registo_Acessos();
            repository.saveAll(List.of(ppp));
        };
    }
}
