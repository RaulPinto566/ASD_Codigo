package com.example.Vacina.Vacina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacinasRepository extends JpaRepository<Vacinas, Long> {
    // Select * From Vacinas Where nome = nome
    @Query("SELECT s FROM Vacinas s WHERE s.nome = ?1")
    Optional<Vacinas> findVacinasBy_Nome(String nome);
}
