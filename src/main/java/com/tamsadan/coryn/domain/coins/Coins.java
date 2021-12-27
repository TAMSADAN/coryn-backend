package com.tamsadan.coryn.domain.coins;

import com.tamsadan.coryn.domain.news.News;
import com.tamsadan.coryn.domain.prices.Prices;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Coins {
    @Id
    @Column(length = 45, nullable = false)
    private String market;

    @Column(name = "korean_name", length = 45)
    private String koreanName;

    @Column(name = "english_name", length = 45)
    private String englishName;

    @Column(name = "logo_uri", length = 100)
    private String logoUri;

    @OneToMany(mappedBy = "market")
    private List<Prices> prices = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "coins_news",
            joinColumns = @JoinColumn(name = "market"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private List<News> news = new ArrayList<>();

    @Builder
    public Coins(String market, String koreanName, String englishName, String logoUri, List<Prices> prices, List<News> news) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.logoUri = logoUri;
        this.prices = prices;
        this.news = news;
    }
}
