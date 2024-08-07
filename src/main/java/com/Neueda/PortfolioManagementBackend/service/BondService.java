package com.Neueda.PortfolioManagementBackend.service;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.model.Stock;
import com.Neueda.PortfolioManagementBackend.repository.BondRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BondService {
    @Autowired
    private BondRepo bondrepo;

    public List<Bond> getAllBonds()
    {
        return bondrepo.findAll();
    }

    public Optional<Bond> getBondById(String id)
    {
        return bondrepo.findById(id);
    }
}

