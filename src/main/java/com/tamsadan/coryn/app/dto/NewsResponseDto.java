package com.tamsadan.coryn.app.dto;

import com.tamsadan.coryn.domain.news.News;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NewsResponseDto {
    private final Long id;
    private final String title;
    private final String posted_date;
    private final String targeting_date;
    private final String newsType;
    private final String source;
    private final String url;

    public NewsResponseDto(News entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.posted_date = entity.getPostedDate();
        this.targeting_date = entity.getTargetingDate();
        this.newsType = entity.getNewsType();
        this.source = entity.getSource();
        this.url = entity.getUrl();
    }
}
