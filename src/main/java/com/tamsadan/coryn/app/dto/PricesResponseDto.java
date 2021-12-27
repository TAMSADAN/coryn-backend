package com.tamsadan.coryn.app.dto;

import com.tamsadan.coryn.domain.prices.Prices;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PricesResponseDto {
    private final Long id;
    private final String market;
    private double openingPrice;
    private double highPrice;
    private double lowPrice;
    private double tradePrice;
    private double closedPrice;
    private double changeRate;
    private double changePrice;
    private double tradeVolume;
    private Long timestamp;
    private String source;
    private String unit;
    private String currency;

    public PricesResponseDto(Prices entity) {
        this.id = entity.getId();
        this.market = entity.getMarket();
        this.openingPrice = entity.getOpeningPrice();
        this.highPrice = entity.getHighPrice();
        this.lowPrice = entity.getLowPrice();
        this.tradePrice = entity.getTradePrice();
        this.closedPrice = entity.getClosedPrice();
        this.changeRate = entity.getChangeRate();
        this.changePrice = entity.getChangePrice();
        this.tradeVolume = entity.getTradeVolume();
        this.timestamp = entity.getTimestamp();
        this.source = entity.getSource();
        this.unit = entity.getUnit();
        this.currency = entity.getCurrency();
    }
}
