package com.example.Utilizadores.Registo_Acessos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Registo_AcessosRepository extends JpaRepository<Registo_Acessos, Long> {
    @Query("SELECT s FROM Registo_Acessos s WHERE s.id = ?1")
    Optional<Registo_Acessos> findRegisto_AcessosBy_Id(String id);
}

