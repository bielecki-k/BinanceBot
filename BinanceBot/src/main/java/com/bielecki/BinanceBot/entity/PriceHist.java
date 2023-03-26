package com.bielecki.BinanceBot.entity;

import javax.persistence.*;
import java.sql.Timestamp;

//@Deprecated
@Entity
@Table(schema = "public",name="price_hist")
public class PriceHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name="currency_name", nullable = false)
    private String currencyName;

    @Column(name="timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name="price", nullable = false)
    private float price;


    public PriceHist() {
    }

    public PriceHist(String currency_name, Timestamp timestamp, float price) {
        this.currencyName = currency_name;
        this.timestamp = timestamp;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }
    public void setCurrencyName(String currencyname) {
        this.currencyName = currencyname;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceHist{" +
                "id=" + id +
                ", currency_name='" + currencyName + '\'' +
                ", timestamp=" + timestamp +
                ", price=" + price +
                '}';
    }
}
