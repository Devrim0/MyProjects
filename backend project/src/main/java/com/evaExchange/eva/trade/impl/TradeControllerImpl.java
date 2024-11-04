package com.evaExchange.eva.trade.impl;

import com.evaExchange.eva.model.TradeRequest;
import com.evaExchange.eva.service.TradeService;
import com.evaExchange.eva.trade.TradeController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
public class TradeControllerImpl implements TradeController {
    private final TradeService tradeService;

    @Override
    public ResponseEntity<String> buy(TradeRequest tradeRequest) {
        try {
            tradeService.buy(tradeRequest.getPortfolioId(), tradeRequest.getShareSymbol(), tradeRequest.getQuantity());
            return new ResponseEntity<>("Buy trade successful", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> sell(TradeRequest tradeRequest) {
        try {
            tradeService.sell(tradeRequest.getPortfolioId(), tradeRequest.getShareSymbol(), tradeRequest.getQuantity());
            return new ResponseEntity<>("Sell trade successful", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
