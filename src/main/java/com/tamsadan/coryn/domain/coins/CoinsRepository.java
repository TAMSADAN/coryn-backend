package com.tamsadan.coryn.domain.coins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoinsRepository extends JpaRepository<Coins, Long> {

    @Query("SELECT c FROM Coins c ORDER BY c.id DESC")
    List<Coins> findAllDesc();
}
