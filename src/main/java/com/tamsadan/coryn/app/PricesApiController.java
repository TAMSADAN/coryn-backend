package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.PricesResponseDto;
import com.tamsadan.coryn.service.prices.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/prices")
public class PricesApiController {
    private final PricesService pricesService;

    @GetMapping("/{market}")
    public List<PricesResponseDto> getPrices(@PathVariable String market, @RequestParam(required = false, defaultValue = "0") String limit) {
        if (Integer.parseInt(limit) == 0) return pricesService.findByMarket(market);
        else return pricesService.findByMarketWithLimit(market, Integer.parseInt(limit));
    }
}
