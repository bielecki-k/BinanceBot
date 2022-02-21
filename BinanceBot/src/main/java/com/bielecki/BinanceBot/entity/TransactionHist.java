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

    @Lob
    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "is_active", nullable = false, precision = 131089)
    private BigDecimal isActive;

    @Column(name = "price_at_buy", nullable = false, precision = 131089)
    private BigDecimal priceAtBuy;

    @Column(name = "bought_price", nullable = false, precision = 131089)
    private BigDecimal boughtPrice;

    @Column(name = "buy_timestamp", nullable = false)
    private Instant buyTimestamp;

    public Instant getBuyTimestamp() {
        return buyTimestamp;
    }

    public void setBuyTimestamp(Instant buyTimestamp) {
        this.buyTimestamp = buyTimestamp;
    }

    public BigDecimal getBoughtPrice() {
        return boughtPrice;
    }

    public void setBoughtPrice(BigDecimal boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public BigDecimal getPriceAtBuy() {
        return priceAtBuy;
    }

    public void setPriceAtBuy(BigDecimal priceAtBuy) {
        this.priceAtBuy = priceAtBuy;
    }

    public BigDecimal getIsActive() {
        return isActive;
    }

    public void setIsActive(BigDecimal isActive) {
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
}