package com.tamsadan.coryn.domain.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT n from News n INNER JOIN n.coins c WHERE c.market = :market ORDER BY n.postedDate DESC")
    List<News> findByMarket(String market);

    @Query("SELECT n from News n WHERE n.newsType = :type ORDER BY n.postedDate DESC")
    List<News> findByType(String type);

    @Query("SELECT n from News n INNER JOIN n.coins c WHERE c.market = :market AND n.newsType = :type ORDER BY n.postedDate DESC")
    List<News> findByMarketAndType(String market, String type);
}
