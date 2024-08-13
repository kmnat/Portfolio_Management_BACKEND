package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BondRepo extends JpaRepository<Bond, Integer> {

    Bond findById_TickerSymbolAndId_TradeDate(String tickerSymbol, Date tradeDate);
    List<Bond> findByIdTradeDate(Date tradeDate);

    @Query(value = "SELECT SUM(bond_price) FROM bond", nativeQuery = true)
    Double sumOfBondPrice();

    @Query(value = "select sum(bond_price), ticker_symbol from bond group by ticker_symbol", nativeQuery = true)
    List<Object> sumOfBondPriceByInstrument();

    @Query(value = "select bond_price, trade_date from bond where ticker_symbol=:id", nativeQuery = true)
    List<Object> getTimeSeriesBond(@Param("id") String id);

}