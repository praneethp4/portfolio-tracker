package com.example.portfolio.dto;

import lombok.Data;

import java.util.Map;

@Data
public class PortfolioResponse {
    private Double totalValue;
    private String topPerformingStock;
    private Map<String, Double> portfolioDistribution;
}
