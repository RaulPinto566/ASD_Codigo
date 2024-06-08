package com.example.Centro_Vac.Marcacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcacaoRepository extends JpaRepository<Marcacao, Long> {
    // Select * From Vacinas Where nome = nome
    @Query("SELECT s FROM Marcacao s WHERE s.id = ?1")
    Optional<Marcacao> findMarcacaoBy_Id(String id);

    @Query("SELECT s FROM Marcacao s WHERE s.utilizador = ?1")
    List<Marcacao> findMarcacaoBy_Utilizador(String utilizador);

    @Query("SELECT s FROM Marcacao s WHERE s.utilizador = ?1")
    Marcacao findMarcacaoBy_Utilizado(String utilizador);
}
