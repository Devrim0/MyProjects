package com.evaExchange.eva.repository;

import com.evaExchange.eva.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}

