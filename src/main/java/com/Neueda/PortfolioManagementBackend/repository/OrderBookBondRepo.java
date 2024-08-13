package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderBookBondRepo extends JpaRepository<OrderBookBond,Integer> {

    List<OrderBookBond> findByBond_Id_TickerSymbol(String id);
}
