package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.OrderBookStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookStockRepo extends JpaRepository<OrderBookStock,Integer> {
}
