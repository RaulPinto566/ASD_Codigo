package com.example.Centro_Vac.Marcacao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MarcacaoConfig {
    @Bean
    CommandLineRunner marcacaocommandLineRunner(MarcacaoRepository repository) {
        return args -> {
            Marcacao pp = new Marcacao();
            Marcacao ppp = new Marcacao("Antonio","2");
            repository.saveAll(List.of(pp,ppp));
        };
    }
}
