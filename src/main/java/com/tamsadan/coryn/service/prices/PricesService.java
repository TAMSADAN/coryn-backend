package com.tamsadan.coryn.service.prices;

import com.tamsadan.coryn.app.dto.PricesResponseDto;
import com.tamsadan.coryn.domain.prices.Prices;
import com.tamsadan.coryn.domain.prices.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PricesService {
    private final PricesRepository pricesRepository;

    @Transactional(readOnly = true)
    public PricesResponseDto findById(Long id) {
        Prices entity = pricesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find prices information of coin. ID="+id));
        return new PricesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PricesResponseDto> findByMarket(String market) {
        return pricesRepository.findByMarketOrderByIdDesc(market).stream().map(PricesResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PricesResponseDto> findByMarketWithLimit(String market, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return pricesRepository.findByMarketWithLimit(market, pageable).stream().map(PricesResponseDto::new).collect(Collectors.toList());
    }
}
