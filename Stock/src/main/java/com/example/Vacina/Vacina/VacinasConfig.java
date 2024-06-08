package com.example.Vacina.Vacina;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VacinasConfig {
    @Bean
    CommandLineRunner vacinacommandLineRunner(VacinasRepository repository) {
        return args -> {
            Vacinas ppp = new Vacinas("ola", "2", "ppp");
            Vacinas ooo = new Vacinas("oladd", "4", "dddd");
            repository.saveAll(List.of(ppp, ooo));
        };
    }
}
