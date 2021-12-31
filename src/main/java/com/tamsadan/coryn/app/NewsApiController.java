package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.NewsResponseDto;
import com.tamsadan.coryn.service.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/news")
public class NewsApiController {
    private final NewsService newsService;

    @GetMapping("")
    public List<NewsResponseDto> getNews(@RequestParam(name = "market", required = false) String market, @RequestParam(name="type", required = false) String type) {
        return newsService.findByMarketAndType(market, type);
    }
}
