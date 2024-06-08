package com.example.Utilizadores.Utilizador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
    @Query("SELECT s FROM Utilizador s WHERE s.id = ?1")
    Optional<Utilizador> findUtilizadorBy_Id(String id);
}
