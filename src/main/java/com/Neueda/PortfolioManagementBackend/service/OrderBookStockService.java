package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.OrderBookStock;
import com.Neueda.PortfolioManagementBackend.repository.OrderBookStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderBookStockService {

    public OrderBookStockService(){

    }

    @Autowired
    private OrderBookStockRepo orderBookStockRepo;

    public List<OrderBookStock> getOrderBookStocks() {
        return orderBookStockRepo.findAll();
    }
}
