package com.tamsadan.coryn.app.dto;

import com.tamsadan.coryn.domain.coins.Coins;
import com.tamsadan.coryn.domain.prices.Prices;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CoinListItemResponseDto {
    private final CoinsResponseDto coin;
    private final PricesResponseDto price;

    public CoinListItemResponseDto(Coins coinEntity, Prices priceEntity) {
        this.coin = new CoinsResponseDto(coinEntity);
        this.price = new PricesResponseDto(priceEntity);
    }
}
