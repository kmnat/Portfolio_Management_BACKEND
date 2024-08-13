package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class OrderBookStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "tickerSymbol", referencedColumnName = "tickerSymbol"),
            @JoinColumn(name = "trade_date", referencedColumnName = "tradeDate")
    })
    private Stock stock;

    @Column(name = "asset_name")
    private String asset_name;

    @Column(name = "volume")
    private Integer volume;

   /* @Column(name = "transaction_date")
    private Date transaction_date;*/

    @Column(name = "bought_price")
    private Double bought_price;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /*public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }*/

    public Double getBought_price() {
        return bought_price;
    }

    public void setBought_price(Double bought_price) {
        this.bought_price = bought_price;
    }
}
/*
INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (150, '2023-01-01', 1000, 'Apple Inc. Stock', 'AAPL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (155, '2023-02-01', 1050, 'Apple Inc. Stock', 'AAPL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (160, '2023-03-01', 1100, 'Apple Inc. Stock', 'AAPL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (250, '2023-01-01', 2000, 'Microsoft Corp. Stock', 'MSFT');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (255, '2023-02-01', 2050, 'Microsoft Corp. Stock', 'MSFT');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (260, '2023-03-01', 2100, 'Microsoft Corp. Stock', 'MSFT');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (350, '2023-01-01', 3000, 'Google LLC Stock', 'GOOGL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (355, '2023-02-01', 3050, 'Google LLC Stock', 'GOOGL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (360, '2023-03-01', 3100, 'Google LLC Stock', 'GOOGL');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (450, '2023-01-01', 4000, 'Amazon Inc. Stock', 'AMZN');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (455, '2023-02-01', 4050, 'Amazon Inc. Stock', 'AMZN');

INSERT INTO order_book_stock (bought_price, trade_date, volume, asset_name, ticker_symbol)
VALUES (460, '2023-03-01', 4100, 'Amazon Inc. Stock', 'AMZN');

 */