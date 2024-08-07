package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @Column(name = "stock_id")
    private String ticker_symbol;

    @Column(name = "average_volume")
    private double averageVolume;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "market_exchange")
    private double marketExchange;

    @Column(name = "stock_price")
    private double stockPrice;

    @Column(name = "week52high")
    private double week52High;

    @Column(name = "week52low")
    private double week52Low;

    public String getStock_id() {
        return ticker_symbol;
    }

    public void setStock_id(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public double getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(double averageVolume) {
        this.averageVolume = averageVolume;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public double getMarketExchange() {
        return marketExchange;
    }

    public void setMarketExchange(double marketExchange) {
        this.marketExchange = marketExchange;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(double week52High) {
        this.week52High = week52High;
    }

    public double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(double week52Low) {
        this.week52Low = week52Low;
    }

}
