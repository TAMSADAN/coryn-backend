package com.tamsadan.coryn.service.coins;

import com.tamsadan.coryn.app.dto.CoinsResponseDto;
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
    public List<CoinsResponseDto> findAllDesc() {
        return coinsRepository.findAllDesc().stream().map(CoinsResponseDto::new).collect(Collectors.toList());
    }
}
