package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
import com.Neueda.PortfolioManagementBackend.repository.OrderBookBondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBookBondService {

    public OrderBookBondService(){

    }

    @Autowired
    private OrderBookBondRepo orderBookBondRepo;

    public List<OrderBookBond> getOrderBookBonds() { return orderBookBondRepo.findAll(); }
}
