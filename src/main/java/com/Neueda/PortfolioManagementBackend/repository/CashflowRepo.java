package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashflowRepo extends JpaRepository<CashflowBook,Integer> {
}
