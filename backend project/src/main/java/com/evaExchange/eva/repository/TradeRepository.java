package com.evaExchange.eva.repository;

import com.evaExchange.eva.entities.Portfolio;
import com.evaExchange.eva.entities.Share;
import com.evaExchange.eva.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByPortfolioAndShare(Portfolio portfolio, Share share);
}

