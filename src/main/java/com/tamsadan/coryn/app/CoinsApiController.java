package com.tamsadan.coryn.app;

import com.tamsadan.coryn.app.dto.CoinsResponseDto;
import com.tamsadan.coryn.service.coins.CoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CoinsApiController {
    private final CoinsService coinsService;

    @GetMapping("/api/v1/coins")
    public List<CoinsResponseDto> coinList() {
        return coinsService.findAllDesc();
    }
}
