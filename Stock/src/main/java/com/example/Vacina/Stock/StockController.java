package com.example.Vacina.Stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stock")
public class StockController {
    private final StockService stockService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStock() {
        return stockService.getStock();
    }

    @PostMapping
    public void registerNewStock(@RequestBody String stock) {
        Stock stocke = null;
        try {
            stocke = objectMapper.readValue(stock, Stock.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        stockService.addNewStock(stocke);
    }

    @DeleteMapping(path = "{stockId}")
    public void deleteStock(@PathVariable("stockId") Long id) {
        stockService.deleteStock(id);
    }

    @PutMapping(path = "{stockId}")
    public void updateStock(@PathVariable("stockId") Long id) {
        stockService.updateStock(id);
    }
}
