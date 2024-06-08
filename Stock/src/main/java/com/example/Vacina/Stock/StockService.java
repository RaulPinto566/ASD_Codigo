package com.example.Vacina.Stock;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStock() {
        return stockRepository.findAll();
    }

    public void addNewStock(Stock stock) {
        stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        if (!stockRepository.existsById(id)) {
            throw new IllegalStateException("stock with id " + id + " does not exist");
        }
        stockRepository.deleteById(id);
    }

    @Transactional
    public void updateStock(Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalStateException("stock with id " + id + " does not exist"));
    }
}
