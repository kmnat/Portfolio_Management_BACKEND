package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class CashflowBook {

    @Id
    private int Cashflow_id;
    @Column
    private String ticker_symbol;
    @Column
    private Date date;
    @Column
    private String asset_name;
    @Column
    private double realized_pnl;
    @Column
    private double unrealized_pnl;

    public String getTicker_symbol() {
        return ticker_symbol;
    }

    public void setTicker_symbol(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public double getRealized_pnl() {
        return realized_pnl;
    }

    public void setRealized_pnl(double realized_pnl) {
        this.realized_pnl = realized_pnl;
    }

    public double getUnrealized_pnl() {
        return unrealized_pnl;
    }

    public void setUnrealized_pnl(double unrealized_pnl) {
        this.unrealized_pnl = unrealized_pnl;
    }

    public int getCashflow_id() {
        return Cashflow_id;
    }

    public void setCashflow_id(int cashflow_id) {
        Cashflow_id = cashflow_id;
    }
}
/*INSERT INTO cashflow_book (cashflow_id, date, realized_pnl, unrealized_pnl, asset_name, ticker_symbol)
VALUES (1, '2023-04-01', 1500.50, 500.75, 'Apple Inc. Stock', 'AAPL');

INSERT INTO cashflow_book (cashflow_id, date, realized_pnl, unrealized_pnl, asset_name, ticker_symbol)
VALUES (2, '2023-05-01', 1600.50, 600.75, 'Apple Inc. Stock', 'AAPL');

INSERT INTO cashflow_book (cashflow_id, date, realized_pnl, unrealized_pnl, asset_name, ticker_symbol)
VALUES (3, '2023-06-01', 1700.50, 700.75, 'Apple Inc. Stock', 'AAPL');

INSERT INTO cashflow_book (cashflow_id, date, realized_pnl, unrealized_pnl, asset_name, ticker_symbol)
VALUES (4, '2023-04-01', 2500.50, 1000.75, 'Microsoft Corp. Stock', 'MSFT');

INSERT INTO cashflow_book (cashflow_id, date, realized_pnl, unrealized_pnl, asset_name, ticker_symbol)
VALUES (5, '2023-05-01', 2600.50, 1100.75, 'Microsoft Corp. Stock', 'MSFT');

*/