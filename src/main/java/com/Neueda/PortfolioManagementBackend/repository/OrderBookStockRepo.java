package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.OrderBookStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderBookStockRepo extends JpaRepository<OrderBookStock,Integer> {
    List<OrderBookStock> findByStock_Id_TickerSymbol(String id);

}
