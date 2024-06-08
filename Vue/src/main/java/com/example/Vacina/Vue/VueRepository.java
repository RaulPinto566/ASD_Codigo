package com.example.Vacina.Vue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface VueRepository extends JpaRepository<Vue, Long> {
    @Query("SELECT s FROM Vue s WHERE s.utilizador = ?1")
    List<Vue> findVueBy_Utilizador(String utilizador);
}
