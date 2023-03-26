package com.bielecki.BinanceBot.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(schema = "public",name="sell_buy_chance")
public class SellBuyChance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(name = "transaction_hist_id", nullable = false, precision = 131089)
    private Integer transaction_hist_id;
    @Column(name = "price_at_chance", nullable = false, precision = 131089)
    private BigDecimal price_at_chance;
    @Column(name = "chance_timestamp", nullable = false, precision = 131089)
    private Instant chance_timestamp;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTransaction_hist_id() {
        return transaction_hist_id;
    }

    public void setTransaction_hist_id(Integer transaction_hist_id) {
        this.transaction_hist_id = transaction_hist_id;
    }

    public BigDecimal getPrice_at_chance() {
        return price_at_chance;
    }

    public void setPrice_at_chance(BigDecimal price_at_chance) {
        this.price_at_chance = price_at_chance;
    }

    public Instant getChance_timestamp() {
        return chance_timestamp;
    }

    public void setChance_timestamp(Instant chance_timestamp) {
        this.chance_timestamp = chance_timestamp;
    }
}
