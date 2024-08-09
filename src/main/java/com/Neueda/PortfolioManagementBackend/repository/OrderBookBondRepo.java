package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookBondRepo extends JpaRepository<OrderBookBond,Integer> {
}
