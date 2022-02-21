package com.bielecki.BinanceBot.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transaction_hist")
public class TransactionHist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @Lob
    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "is_active", nullable = false, precision = 131089)
    private Integer isActive;

    @Column(name = "price_at_buy", nullable = false, precision = 131089)
    private BigDecimal priceAtBuy;

    @Column(name = "bought_amount", nullable = false, precision = 131089)
    private BigDecimal boughtAmount;

    @Column(name = "buy_timestamp", nullable = false)
    private Instant buyTimestamp;

    public Instant getBuyTimestamp() {
        return buyTimestamp;
    }

    public void setBuyTimestamp(Instant buyTimestamp) {
        this.buyTimestamp = buyTimestamp;
    }

    public BigDecimal getBoughtAmount() {
        return boughtAmount;
    }

    public void setBoughtAmount(BigDecimal boughtAmount) {
        this.boughtAmount = boughtAmount;
    }

    public BigDecimal getPriceAtBuy() {
        return priceAtBuy;
    }

    public void setPriceAtBuy(BigDecimal priceAtBuy) {
        this.priceAtBuy = priceAtBuy;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TransactionHist{" +
                "id=" + id +
                ", currencyName='" + currencyName + '\'' +
                ", isActive=" + isActive +
                ", priceAtBuy=" + priceAtBuy +
                ", boughtAmount=" + boughtAmount +
                ", buyTimestamp=" + buyTimestamp +
                '}';
    }
}