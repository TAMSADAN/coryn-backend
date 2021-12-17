package com.tamsadan.coryn.domain.coins;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Coins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String market;

    @Column(length = 20, nullable = false)
    private String koreanName;

    @Column(length = 20, nullable = false)
    private String englishName;

    @Column(length = 100, nullable = false)
    private String logoUri;

    @Builder
    public Coins(String market, String koreanName, String englishName, String logoUri) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.logoUri = logoUri;
    }
}
