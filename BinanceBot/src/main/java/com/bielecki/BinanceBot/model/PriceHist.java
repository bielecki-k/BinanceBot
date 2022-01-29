package com.bielecki.BinanceBot.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="price_hist")
public class PriceHist {


    private long id;
    private String currency_name;
    private Timestamp timestamp;
    private float price;


    public PriceHist() {
    }

    public PriceHist(String currency_name, Timestamp timestamp, float price) {
        this.currency_name = currency_name;
        this.timestamp = timestamp;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="currency_name", nullable = false)
    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    @Column(name="timestamp", nullable = false)
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name="price", nullable = false)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
