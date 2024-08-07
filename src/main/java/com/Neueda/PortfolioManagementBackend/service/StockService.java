package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepo stockrepo;

    public List<Stock> getAllStocks()
    {
        return stockrepo.findAll();
    }

    public Optional<Stock> getStockById(String id)
    {
        return stockrepo.findById(id);
    }
}