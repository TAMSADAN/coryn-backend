package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.CoinListItemResponseDto;
import com.tamsadan.coryn.service.coinListItem.CoinListItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/coins")
public class CoinListItemApiController {
    private final CoinListItemService coinListItemService;

    @GetMapping("")
    public List<CoinListItemResponseDto> getCoinListItemList() {
        return coinListItemService.findAll();
    }

    @GetMapping("/{market}")
    public CoinListItemResponseDto getCoinListItem(@PathVariable String market) {
        return coinListItemService.findByMarket(market);
    }
}
