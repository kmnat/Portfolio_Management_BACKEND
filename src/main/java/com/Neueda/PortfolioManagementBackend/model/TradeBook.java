package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TradeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trade_id;
    @Column(name="ticker_symbol")
    private String ticker_symbol;
    @Column
    private String asset_name;
    @Column
    private String category;
    @Column
    private Date date;
    @Column
    private String action;
    @Column
    private int volume;
    @Column
    private double amount;

    public String getTicker_symbol() {
        return ticker_symbol;
    }

    public void setTicker_symbol(String ticker_symbol) {
        this.ticker_symbol = ticker_symbol;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(int trade_id) {
        this.trade_id = trade_id;
    }


}