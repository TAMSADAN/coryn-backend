package com.tamsadan.coryn.service.coins;

import com.tamsadan.coryn.app.dto.CoinsResponseDto;
import com.tamsadan.coryn.domain.coins.Coins;
import com.tamsadan.coryn.domain.coins.CoinsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CoinsService {
    private final CoinsRepository coinsRepository;

    @Transactional(readOnly = true)
    public List<CoinsResponseDto> findAll() {
        return coinsRepository.findAll().stream().map(CoinsResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CoinsResponseDto findByMarket(String market) {
        Coins entity = coinsRepository.findByMarket(market)
                .orElseThrow(() -> new IllegalArgumentException("해당 코인 정보가 존재하지 않습니다. market="+market));
        return new CoinsResponseDto(entity);
    }
}
