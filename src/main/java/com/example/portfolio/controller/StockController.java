package com.example.portfolio.controller;

import com.example.portfolio.entity.Stock;
import com.example.portfolio.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/portfolio-value")
    public Double getPortfolioValue() {
        return stockService.calculatePortfolioValue();
    }

    @PostMapping("/create-random-portfolio")
    public String createRandomPortfolio() {
        stockService.createRandomPortfolioForUser();
        return "Random portfolio created successfully!";
    }
    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock); // Ensure this method exists in StockService
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
