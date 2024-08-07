package com.Neueda.PortfolioManagementBackend.RESTController;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import com.Neueda.PortfolioManagementBackend.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bonds")
public class BondController {
    @Autowired
    private BondService bondService;

    @GetMapping
    public List<Bond> getAllBonds()
    {
        return bondService.getAllBonds();
    }

    @GetMapping("/{id}")
    public Optional<Bond> getBondById(@PathVariable String id)
    {
        return bondService.getBondById(id);
    }
}
