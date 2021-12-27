package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.PricesResponseDto;
import com.tamsadan.coryn.service.prices.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PricesApiController {
    private final PricesService pricesService;

    @GetMapping("/api/v1/coins/{market}/prices")
    public List<PricesResponseDto> getPrices(@PathVariable String market, @RequestParam(required = false, defaultValue = "0") String limit) {
        if (Integer.parseInt(limit) == 0) return pricesService.findByMarket(market);
        else return pricesService.findByMarketWithLimit(market, Integer.parseInt(limit));
    }
}
