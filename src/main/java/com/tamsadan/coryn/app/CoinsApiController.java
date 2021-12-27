package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.CoinsResponseDto;
import com.tamsadan.coryn.service.coins.CoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/coins")
public class CoinsApiController {
    private final CoinsService coinsService;

    @GetMapping("")
    public List<CoinsResponseDto> getCoinList() {
        return coinsService.findAll();
    }

    @GetMapping("/{market}")
    public CoinsResponseDto getCoin(@PathVariable String market) {
        return coinsService.findByMarket(market);
    }
}
