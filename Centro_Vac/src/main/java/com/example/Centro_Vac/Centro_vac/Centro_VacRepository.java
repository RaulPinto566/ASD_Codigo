package com.example.Centro_Vac.Centro_vac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Centro_VacRepository extends JpaRepository<Centro_Vac, Long> {
    // Select * From Vacinas Where nome = nome
    @Query("SELECT s FROM Centro_Vac s WHERE s.id = ?1")
    Optional<Centro_Vac> findCentro_VacBy_Id(String id);

    @Query("SELECT s FROM Centro_Vac s WHERE s.nome = ?1")
    Centro_Vac findCentro_VacBy_NOME(String nome);

    @Query("SELECT s FROM Centro_Vac s WHERE s.nome = ?1")
    Optional<Centro_Vac> findCentro_VacBy_NOM(String nome);

    @Query("SELECT s FROM Centro_Vac s WHERE s.localidade = ?1")
    List<Centro_Vac> findCentro_VacBy_LOACALIDADE(String localidade);
}
