package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
public class BondId implements Serializable {

    private String tickerSymbol;
    private Date tradeDate;

    // Default constructor
    public BondId() {}

    public BondId(String tickerSymbol, Date tradeDate) {
        this.tickerSymbol = tickerSymbol;
        this.tradeDate = tradeDate;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String ticker_symbol) {
        this.tickerSymbol = ticker_symbol;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    // Getters and Setters

    // hashCode and equals methods (necessary for composite keys)
    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol, tradeDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BondId that = (BondId) obj;
        return Objects.equals(tickerSymbol, that.tickerSymbol) &&
                Objects.equals(tradeDate, that.tradeDate);
    }
}
