package com.evaExchange.eva.service;

import org.springframework.stereotype.Service;

public interface TradeService {
    void buy(Long portfolioId, String shareSymbol, Integer quantity) throws Exception;

    void sell(Long portfolioId, String shareSymbol, Integer quantity) throws Exception;
}
