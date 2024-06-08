package com.example.Vacina.Stock;

import com.example.Vacina.Vacina.Vacinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT s FROM Stock s WHERE s.id = ?1")
    Optional<Stock> findStockBy_Id(String id);
}
