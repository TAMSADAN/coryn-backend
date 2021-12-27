package com.tamsadan.coryn.domain.coins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoinsRepository extends JpaRepository<Coins, String> {
    List<Coins> findAll();
    Optional<Coins> findByMarket(String market);
}
