package com.Neueda.PortfolioManagementBackend.model;

import jakarta.persistence.*;

@Entity
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bond_id;

    @Column(name = "bond_price")
    private double bondPrice;

    @Column(name = "coupon_rate")
    private double couponRate;

    @Column(name = "credit_rating")
    private double creditRating;

    @Column(name = "face_value")
    private double faceValue;

    private String issuer;

    @Column(name = "maturity_date")
    private String maturityDate;

    public Integer getBond_id() {
        return bond_id;
    }

    public void setBond_id(Integer bond_id) {
        this.bond_id = bond_id;
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
