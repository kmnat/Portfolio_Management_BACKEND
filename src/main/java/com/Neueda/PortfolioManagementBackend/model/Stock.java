package com.Neueda.PortfolioManagementBackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;

@Entity
public class Stock {
    @EmbeddedId
    @JsonUnwrapped
    private StockId id;

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

    public StockId getId() {
        return id;
    }

    public void setId(StockId id) {
        this.id = id;
    }

    @Column(name = "week52high")
    private double week52High;

    @Column(name = "week52low")
    private double week52Low;

    @Column(name = "current_price")
    private double currentPrice;


    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
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

/*INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AAPL', '2023-01-01', 1000000, 'Apple Inc.', 'Technology', 200.5, 150.0, 175.0, 125.0, 151.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AAPL', '2023-02-01', 1005000, 'Apple Inc.', 'Technology', 201.0, 151.0, 176.0, 126.0, 152.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AAPL', '2023-03-01', 1010000, 'Apple Inc.', 'Technology', 202.0, 152.0, 177.0, 127.0, 153.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('MSFT', '2023-01-01', 2000000, 'Microsoft Corp.', 'Technology', 300.5, 250.0, 275.0, 225.0, 251.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('MSFT', '2023-02-01', 2005000, 'Microsoft Corp.', 'Technology', 301.0, 251.0, 276.0, 226.0, 252.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('MSFT', '2023-03-01', 2010000, 'Microsoft Corp.', 'Technology', 302.0, 252.0, 277.0, 227.0, 253.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('GOOGL', '2023-01-01', 3000000, 'Google LLC', 'Technology', 400.5, 350.0, 375.0, 325.0, 351.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('GOOGL', '2023-02-01', 3005000, 'Google LLC', 'Technology', 401.0, 351.0, 376.0, 326.0, 352.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('GOOGL', '2023-03-01', 3010000, 'Google LLC', 'Technology', 402.0, 352.0, 377.0, 327.0, 353.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AMZN', '2023-01-01', 4000000, 'Amazon Inc.', 'E-commerce', 500.5, 450.0, 475.0, 425.0, 451.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AMZN', '2023-02-01', 4005000, 'Amazon Inc.', 'E-commerce', 501.0, 451.0, 476.0, 426.0, 452.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('AMZN', '2023-03-01', 4010000, 'Amazon Inc.', 'E-commerce', 502.0, 452.0, 477.0, 427.0, 453.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('TSLA', '2023-01-01', 5000000, 'Tesla Inc.', 'Automotive', 600.5, 550.0, 575.0, 525.0, 551.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('TSLA', '2023-02-01', 5005000, 'Tesla Inc.', 'Automotive', 601.0, 551.0, 576.0, 526.0, 552.0);

INSERT INTO Stock (ticker_symbol, trade_date, average_volume, company_name, industry, market_exchange, stock_price, week52high, week52low, current_price)
VALUES ('TSLA', '2023-03-01', 5010000, 'Tesla Inc.', 'Automotive', 602.0, 552.0, 577.0, 527.0, 553.0);
*/
