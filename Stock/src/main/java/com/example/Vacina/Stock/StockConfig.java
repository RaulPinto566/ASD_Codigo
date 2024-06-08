package com.example.Vacina.Stock;

import com.example.Vacina.Vacina.Vacinas;
import com.example.Vacina.Vacina.VacinasRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StockConfig {
    @Bean
    CommandLineRunner stockcommandLineRunner(StockRepository repository) {
        return args -> {
            Stock ppp = new Stock();
            repository.saveAll(List.of(ppp));
        };
    }
}
