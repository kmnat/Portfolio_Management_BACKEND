package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import com.Neueda.PortfolioManagementBackend.repository.CashflowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashflowService {

    @Autowired
    private CashflowRepo cashflowRepo;

    public List<CashflowBook> getCashflowBook()
    {
        return cashflowRepo.findAll();
    }
}

