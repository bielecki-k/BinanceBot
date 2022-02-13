package com.bielecki.BinanceBot.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(schema = "public",name="price_hist")
public class PriceHist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name="currency_name", nullable = false)
    private String curencyName;

    @Column(name="timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name="price", nullable = false)
    private float price;


    public PriceHist() {
    }

    public PriceHist(String currency_name, Timestamp timestamp, float price) {
        this.curencyName = currency_name;
        this.timestamp = timestamp;
        this.price = price;
    }

    public PriceHist(Long id, String currency_name, Timestamp timestamp, float price) {
        this.id = id;
        this.curencyName = currency_name;
        this.timestamp = timestamp;
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCurrencyname() {
        return curencyName;
    }
    public void setCurrencyname(String currencyname) {
        this.curencyName = currencyname;
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
                ", currency_name='" + curencyName + '\'' +
                ", timestamp=" + timestamp +
                ", price=" + price +
                '}';
    }
}
