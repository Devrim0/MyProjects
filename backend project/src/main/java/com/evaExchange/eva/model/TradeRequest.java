package com.evaExchange.eva.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeRequest {
    private Long portfolioId;
    private String shareSymbol;
    private Integer quantity;
}
