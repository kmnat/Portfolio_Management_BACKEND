//package com.Neueda.PortfolioManagementBackend.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//
//import java.util.Date;
//
//@Entity
//public class OrderBookBond {
//    @OneToOne
//    @JoinColumn(name = "ticker_symbol", referencedColumnName = "ticker_symbol")
//    private Bond bond;
//
//    @Column(name = "asset_name")
//    private String asset_name;
//
//    @Column(name = "transaction_date")
//    private Date transaction_date;
//
//    @Column(name = "bond_price")
//    private Integer bond_price;
//
//    @Column(name = "maturity_date")
//    private Date maturityDate;
//}
