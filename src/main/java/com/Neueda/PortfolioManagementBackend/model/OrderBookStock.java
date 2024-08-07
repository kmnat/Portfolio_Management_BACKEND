package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class OrderBookStock {
    @OneToOne
    @JoinColumn(name = "ticker_symbol", referencedColumnName = "ticker_symbol")
    private Stock stock;

    @Column(name = "asset_name")
    private String asset_name;

    @Column(name = "volume")
    private Integer volume;

    @Column(name = "transaction_date")
    private Date transaction_date;

    @Column(name = "bought_price")
    private Integer bought_price;
}
