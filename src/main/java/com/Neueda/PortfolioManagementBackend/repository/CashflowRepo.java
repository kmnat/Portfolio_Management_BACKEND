package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.CashFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashflowRepo extends JpaRepository<CashFlow, Long> {
}
