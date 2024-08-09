package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import com.Neueda.PortfolioManagementBackend.model.TradeBook;
import com.Neueda.PortfolioManagementBackend.repository.CashflowRepo;
import com.Neueda.PortfolioManagementBackend.repository.TradeBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TradeBookService {

    public TradeBookService() {

    }

    @Autowired
    private TradeBookRepo tradeBookRepo;

    public List<TradeBook> getTradeBook()
    {
        return tradeBookRepo.findAll();
    }
}



