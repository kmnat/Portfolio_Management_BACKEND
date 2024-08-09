package com.Neueda.PortfolioManagementBackend.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;

@Entity
public class Bond {
    @EmbeddedId
    @JsonUnwrapped
    private BondId id;

    @Column(name = "bond_price")
    private double bondPrice;

    @Column(name = "coupon_rate")
    private double couponRate;

    @Column(name = "credit_rating")
    private double creditRating;

    @Column(name = "face_value")
    private double faceValue;

    @Column(name = "maturity_date")
    private String maturityDate;

    @Column(name = "maturity_amount")
    private String maturityAmount;


    private String issuer;

    public BondId getId() {
        return id;
    }

    public void setId(BondId id) {
        this.id = id;
    }



    public String getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(String maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public double getBondPrice() {
        return bondPrice;
    }

    public void setBondPrice(double bondPrice) {
        this.bondPrice = bondPrice;
    }

    public double getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(double couponRate) {
        this.couponRate = couponRate;
    }

    public double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(double creditRating) {
        this.creditRating = creditRating;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }
}

/*
use <database name>>;
INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AAPL', '2023-01-01', 300.5, 2.5, 4.7, 3000.0, 'Apple Inc.', '1500.00', '2025-01-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AAPL', '2023-02-01', 305.0, 2.6, 4.8, 3050.0, 'Apple Inc.', '1525.00', '2025-02-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AAPL', '2023-03-01', 310.0, 2.7, 4.9, 3100.0, 'Apple Inc.', '1550.00', '2025-03-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('MSFT', '2023-01-01', 400.5, 3.0, 5.0, 4000.0, 'Microsoft Corp.', '2000.00', '2026-01-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('MSFT', '2023-02-01', 405.0, 3.1, 5.1, 4050.0, 'Microsoft Corp.', '2025.00', '2026-02-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('MSFT', '2023-03-01', 410.0, 3.2, 5.2, 4100.0, 'Microsoft Corp.', '2050.00', '2026-03-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('GOOGL', '2023-01-01', 500.5, 3.5, 5.3, 5000.0, 'Google LLC', '2500.00', '2027-01-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('GOOGL', '2023-02-01', 505.0, 3.6, 5.4, 5050.0, 'Google LLC', '2525.00', '2027-02-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('GOOGL', '2023-03-01', 510.0, 3.7, 5.5, 5100.0, 'Google LLC', '2550.00', '2027-03-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AMZN', '2023-01-01', 600.5, 4.0, 5.6, 6000.0, 'Amazon Inc.', '3000.00', '2028-01-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AMZN', '2023-02-01', 605.0, 4.1, 5.7, 6050.0, 'Amazon Inc.', '3025.00', '2028-02-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('AMZN', '2023-03-01', 610.0, 4.2, 5.8, 6100.0, 'Amazon Inc.', '3050.00', '2028-03-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('TSLA', '2023-01-01', 700.5, 4.5, 5.9, 7000.0, 'Tesla Inc.', '3500.00', '2029-01-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('TSLA', '2023-02-01', 705.0, 4.6, 6.0, 7050.0, 'Tesla Inc.', '3525.00', '2029-02-01');

INSERT INTO Bond (ticker_symbol, trade_date, bond_price, coupon_rate, credit_rating, face_value, issuer, maturity_amount, maturity_date)
VALUES ('TSLA', '2023-03-01', 710.0, 4.7, 6.1, 7100.0, 'Tesla Inc.', '3550.00', '2029-03-01');

*/
