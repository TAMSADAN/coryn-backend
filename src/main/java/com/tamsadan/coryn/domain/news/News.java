package com.tamsadan.coryn.domain.news;

import com.tamsadan.coryn.domain.coins.Coins;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "posted_date")
    private String postedDate;

    @Column(name = "targeting_date")
    private String targetingDate;

    @Column(name = "news_type", length = 10)
    private String newsType;

    @Column(length = 100)
    private String source;

    private String url;

    @ManyToMany(mappedBy = "news")
    private List<Coins> coins = new ArrayList<>();

    @Builder
    public News(Long id, String title, String postedDate, String targetingDate, String newsType, String source, String url, List<Coins> coins) {
        this.id = id;
        this.title = title;
        this.postedDate = postedDate;
        this.targetingDate = targetingDate;
        this.newsType = newsType;
        this.source = source;
        this.url = url;
        this.coins = coins;
    }
}
