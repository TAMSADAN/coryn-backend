package com.tamsadan.coryn.service.coinListItem;

import com.tamsadan.coryn.app.dto.CoinListItemResponseDto;
import com.tamsadan.coryn.domain.coins.Coins;
import com.tamsadan.coryn.domain.coins.CoinsRepository;
import com.tamsadan.coryn.domain.prices.Prices;
import com.tamsadan.coryn.domain.prices.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CoinListItemService {
    private final CoinsRepository coinsRepository;
    private final PricesRepository pricesRepository;

    @Transactional(readOnly = true)
    public List<CoinListItemResponseDto> findAll() {
        List<CoinListItemResponseDto> result = new ArrayList<>();

        List<Coins> coins = coinsRepository.findAll();
        for(Coins coin:coins) {
            Prices price = pricesRepository.findTopByMarketOrderByIdDesc(coin.getMarket())
                    .orElseThrow(() -> new IllegalArgumentException("해당 코인의 가격 정보가 존재하지 않습니다. market="+coin.getMarket()));
            result.add(new CoinListItemResponseDto(coin, price));
        }

        return result;
    }

    @Transactional(readOnly = true)
    public CoinListItemResponseDto findByMarket(String market) {
        Coins coin = coinsRepository.findByMarket(market)
                .orElseThrow(() -> new IllegalArgumentException("해당 코인 정보가 존재하지 않습니다. market="+market));
        Prices price = pricesRepository.findTopByMarketOrderByIdDesc(coin.getMarket())
                .orElseThrow(() -> new IllegalArgumentException("해당 코인의 가격 정보가 존재하지 않습니다. market="+coin.getMarket()));

        return new CoinListItemResponseDto(coin, price);
    }
}
