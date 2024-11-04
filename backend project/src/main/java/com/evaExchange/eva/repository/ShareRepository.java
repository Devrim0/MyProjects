package com.evaExchange.eva.repository;

import com.evaExchange.eva.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShareRepository extends JpaRepository<Share, Long> {
    Optional<Share> findBySymbol(String symbol);
}

