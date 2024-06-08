package com.example.Centro_Vac.Centro_vac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Centro_VacConfig {
    @Bean
    CommandLineRunner centro_vaccommandLineRunner(Centro_VacRepository repository) {
        return args -> {
            Centro_Vac pp = new Centro_Vac();
            Centro_Vac ppp = new Centro_Vac("pita","braga");
            repository.saveAll(List.of(pp,ppp));
        };
    }
}
