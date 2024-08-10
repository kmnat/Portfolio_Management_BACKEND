package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.repository.BondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BondService {
    @Autowired
    private BondRepo bondrepo;

    public List<Bond> getAllBonds()
    {
        return bondrepo.findAll();
    }

    public Double sumOfBondPrice()
    {
        return bondrepo.sumOfBondPrice();
    }

    public List<Object> sumOfBondPriceByInstrument()
    {
        return bondrepo.sumOfBondPriceByInstrument();
    }

    public List<Object> getTimeSeriesBond(String id)
    {
        return bondrepo.getTimeSeriesBond(id);
    }

}

