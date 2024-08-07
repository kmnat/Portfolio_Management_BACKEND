package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BondRepo extends JpaRepository<Bond, String> {
}
