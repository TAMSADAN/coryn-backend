package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.NewsResponseDto;
import com.tamsadan.coryn.service.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/news")
public class NewsApiController {
    private final NewsService newsService;

    @GetMapping("/{market}")
    public List<NewsResponseDto> getNews(@PathVariable String market) {
        return newsService.findByMarket(market);
    }
}
