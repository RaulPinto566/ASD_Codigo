package com.example.Centro_Vac.Administracao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdministracaoRepository extends JpaRepository<Administracao, Long> {
    @Query("SELECT s FROM Administracao s WHERE s.id = ?1")
    Optional<Administracao> findAdministracaoBy_Id(String id);
}
