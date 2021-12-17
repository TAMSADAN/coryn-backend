package com.tamsadan.coryn.app.dto;

import com.tamsadan.coryn.domain.coins.Coins;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CoinsResponseDto {
    private final String market;
    private final String koreanName;
    private final String englishName;
    private final String logoUri;

    public CoinsResponseDto(Coins entity) {
        this.market = entity.getMarket();
        this.koreanName = entity.getKoreanName();
        this.englishName = entity.getEnglishName();
        this.logoUri = entity.getLogoUri();
    }
}
