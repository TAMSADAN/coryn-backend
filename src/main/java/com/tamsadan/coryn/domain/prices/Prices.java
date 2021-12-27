package com.tamsadan.coryn.domain.prices;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String market;

    @Column(name = "opening_price")
    private double openingPrice;

    @Column(name = "high_price")
    private double highPrice;

    @Column(name = "low_price")
    private double lowPrice;

    @Column(name = "trade_price")
    private double tradePrice;

    @Column(name = "closed_price")
    private double closedPrice;

    @Column(name = "change_rate")
    private double changeRate;

    @Column(name = "change_price")
    private double changePrice;

    @Column(name = "trade_volume")
    private double tradeVolume;

    private Long timestamp;

    @Column(length = 45)
    private String source;

    @Column(length = 45)
    private String unit;

    @Column(length = 45)
    private String currency;

    @Builder
    public Prices(Long id, String market, double openingPrice, double highPrice, double lowPrice, double tradePrice, double closedPrice, double changeRate, double changePrice, double tradeVolume, Long timestamp, String source, String unit, String currency) {
        this.id = id;
        this.market = market;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice = tradePrice;
        this.closedPrice = closedPrice;
        this.changeRate = changeRate;
        this.changePrice = changePrice;
        this.tradeVolume = tradeVolume;
        this.source = source;
        this.unit = unit;
        this.currency = currency;
    }
}
