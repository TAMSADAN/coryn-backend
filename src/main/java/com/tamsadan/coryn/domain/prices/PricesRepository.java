package com.tamsadan.coryn.domain.prices;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PricesRepository extends JpaRepository<Prices, Long> {
    List<Prices> findByMarketOrderByIdDesc(String market);

    @Query("SELECT p from Prices p WHERE p.market = :market ORDER BY p.id DESC")
    List<Prices> findByMarketWithLimit(@Param("market") String market, Pageable pageable);

    Optional<Prices> findTopByMarketOrderByIdDesc(String market);
}
