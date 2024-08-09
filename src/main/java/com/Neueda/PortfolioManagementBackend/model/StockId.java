package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class StockId implements Serializable {

    private String ticker_symbol;
    private Date tradeDate;

    // Default constructor
    public StockId() {}

    public StockId(String tickerSymbol, Date tradeDate) {
        this.ticker_symbol = tickerSymbol;
        this.tradeDate = tradeDate;
    }

    // Getters and Setters

    public String getTicker_symbol() {
        return ticker_symbol;
    }

    public void setTicker_symbol(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    // hashCode and equals methods (necessary for composite keys)
    @Override
    public int hashCode() {
        return Objects.hash(ticker_symbol, tradeDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StockId that = (StockId) obj;
        return Objects.equals(ticker_symbol, that.ticker_symbol) &&
                Objects.equals(tradeDate, that.tradeDate);
    }
}

