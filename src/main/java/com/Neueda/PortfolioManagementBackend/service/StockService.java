package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepo stockrepo;

    public List<Stock> getAllStocks()
    {
        return stockrepo.findAll();
    }


    public Double sumOfStockPrice()
    {
        return stockrepo.sumOfStockPrice();
    }

    public List<Object> sumOfStockPriceByInstrument()
    {
        return stockrepo.sumOfStockPriceByInstrument();
    }

    public List<Object> getTimeSeriesStock(String id)
    {
        return stockrepo.getTimeSeriesStock(id);
    }

}