package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class StockId implements Serializable {

    private String tickerSymbol;
    private Date tradeDate;

    // Default constructor
    public StockId() {}

    public StockId(String tickerSymbol, Date tradeDate) {
        this.tickerSymbol = tickerSymbol;
        this.tradeDate = tradeDate;
    }

    // Getters and Setters

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
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
        return Objects.hash(tickerSymbol, tradeDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StockId that = (StockId) obj;
        return Objects.equals(tickerSymbol, that.tickerSymbol) &&
                Objects.equals(tradeDate, that.tradeDate);
    }
}

