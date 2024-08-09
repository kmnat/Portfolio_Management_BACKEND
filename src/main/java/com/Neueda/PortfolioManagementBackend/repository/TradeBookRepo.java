package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import com.Neueda.PortfolioManagementBackend.model.TradeBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeBookRepo extends JpaRepository<TradeBook,Integer> {
}
