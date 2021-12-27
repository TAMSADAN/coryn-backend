package com.tamsadan.coryn.service.news;

import com.tamsadan.coryn.app.dto.NewsResponseDto;
import com.tamsadan.coryn.domain.news.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Transactional(readOnly = true)
    public List<NewsResponseDto> findByMarket(String market) {
        return newsRepository.findByMarket(market).stream().map(NewsResponseDto::new).collect(Collectors.toList());
    }
}
