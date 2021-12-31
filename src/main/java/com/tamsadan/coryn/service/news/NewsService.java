package com.tamsadan.coryn.service.news;

import com.tamsadan.coryn.app.dto.CoinsResponseDto;
import com.tamsadan.coryn.app.dto.NewsResponseDto;
import com.tamsadan.coryn.domain.news.News;
import com.tamsadan.coryn.domain.news.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Transactional(readOnly = true)
    public List<NewsResponseDto> findByMarketAndType(String market, String type) {
        if(market == null && type == null) return new ArrayList<>();

        List<News> result;
        if(type == null) result = newsRepository.findByMarket(market);
        else if(market == null) result = newsRepository.findByType(type);
        else result = newsRepository.findByMarketAndType(market, type);

        return result.stream().map(NewsResponseDto::new).collect(Collectors.toList());
    }
}
