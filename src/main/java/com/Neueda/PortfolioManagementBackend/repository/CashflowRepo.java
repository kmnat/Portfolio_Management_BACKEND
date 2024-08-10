package com.Neueda.PortfolioManagementBackend.repository;

import com.Neueda.PortfolioManagementBackend.model.CashflowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CashflowRepo extends JpaRepository<CashflowBook,Integer> {
    @Query(value = "select sum(realized_pnl), ticker_symbol from cashflow_book group by ticker_symbol;", nativeQuery = true)
    List<Object> pnlCashFlow();

    @Query(value = "select sum(realized_pnl), sum(unrealized_pnl), sum(realized_pnl + unrealized_pnl), ticker_symbol from cashflow_book group by ticker_symbol", nativeQuery = true)
    List<Object> allPnlCashFlow();
}
