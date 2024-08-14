package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
    @Query(value = "SELECT SUM(stock_price) FROM stock", nativeQuery = true)
    Double sumOfStockPrice();

    @Query(value = "select sum(stock_price), ticker_symbol from stock group by ticker_symbol;", nativeQuery = true)
    List<Object> sumOfStockPriceByInstrument();

    @Query(value = "select stock_price, trade_date from stock where ticker_symbol=:id", nativeQuery = true)
    List<Object> getTimeSeriesStock(@Param("id") String id);

    List<Stock> findByIdTradeDate(Date tradeDate);

    Stock findById_TickerSymbolAndId_TradeDate(String tickerSymbol, Date tradeDate);
}
