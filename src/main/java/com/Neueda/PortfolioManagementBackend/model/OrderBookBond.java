package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class OrderBookBond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "tickerSymbol", referencedColumnName = "tickerSymbol"),
            @JoinColumn(name = "trade_date", referencedColumnName = "tradeDate")
    })
    private Bond bond;

    @Column(name = "asset_name")
    private String asset_name;

    /*@Column(name = "transaction_date")
    private Date transaction_date;*/

    @Column(name = "bond_price")
    private Double bond_price;


    @Column(name = "maturity_date")
    private Date maturityDate;

    @Column(name = "maturity_amount")
    private double maturityAmount;

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(double maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

 /*   public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }*/

    public Double getBond_price() {
        return bond_price;
    }

    public void setBond_price(Double bond_price) {
        this.bond_price = bond_price;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }


}
/*
INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (300, '2023-01-01', '2025-01-01 00:00:00', 'Google LLC Bond', 'GOOGL');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (350, '2023-02-01', '2025-02-01 00:00:00', 'Google LLC Bond', 'GOOGL');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (400, '2023-03-01', '2025-03-01 00:00:00', 'Google LLC Bond', 'GOOGL');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (200, '2023-01-01', '2025-01-01 00:00:00', 'Microsoft Corp. Bond', 'MSFT');
INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (250, '2023-02-01', '2025-02-01 00:00:00', 'Microsoft Corp. Bond', 'MSFT');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (300, '2023-03-01', '2025-03-01 00:00:00', 'Microsoft Corp. Bond', 'MSFT');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (400, '2023-01-01', '2025-01-01 00:00:00', 'Amazon Inc. Bond', 'AMZN');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (450, '2023-02-01', '2025-02-01 00:00:00', 'Amazon Inc. Bond', 'AMZN');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (500, '2023-03-01', '2025-03-01 00:00:00', 'Amazon Inc. Bond', 'AMZN');

INSERT INTO order_book_bond (bond_price, trade_date, maturity_date, asset_name, ticker_symbol)
VALUES (600, '2023-01-01', '2025-01-01 00:00:00', 'Tesla Inc. Bond', 'TSLA');
 */