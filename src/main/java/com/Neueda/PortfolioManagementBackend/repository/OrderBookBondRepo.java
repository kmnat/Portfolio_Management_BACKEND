package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.OrderBookBond;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrderBookBondRepo extends JpaRepository<OrderBookBond,Integer> {


    List<OrderBookBond> findByBond_Id_TickerSymbolAndBond_Id_TradeDate(String tickerSymbol, Date tradeDate);
}
