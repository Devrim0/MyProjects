package com.evaExchange.eva.service.impl;

import com.evaExchange.eva.entities.Portfolio;
import com.evaExchange.eva.entities.Share;
import com.evaExchange.eva.entities.Trade;
import com.evaExchange.eva.repository.PortfolioRepository;
import com.evaExchange.eva.repository.ShareRepository;
import com.evaExchange.eva.repository.TradeRepository;
import com.evaExchange.eva.repository.UserRepository;
import com.evaExchange.eva.service.TradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TradeServiceImpl implements TradeService {
    private final UserRepository userRepository;

    private final PortfolioRepository portfolioRepository;

    private final ShareRepository shareRepository;

    private final TradeRepository tradeRepository;

    public void buy(Long portfolioId, String shareSymbol, Integer quantity) throws Exception {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new Exception("Invalid portfolio"));
        Share share = shareRepository.findBySymbol(shareSymbol).orElseThrow(() -> new Exception("Invalid share symbol"));

        Trade trade = new Trade();
        trade.setPortfolio(portfolio);
        trade.setShare(share);
        trade.setQuantity(quantity);
        trade.setTradeType("BUY");

        tradeRepository.save(trade);
    }

    public void sell(Long portfolioId, String shareSymbol, Integer quantity) throws Exception {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new Exception("Invalid portfolio"));
        Share share = shareRepository.findBySymbol(shareSymbol).orElseThrow(() -> new Exception("Invalid share symbol"));

        List<Trade> trades = tradeRepository.findByPortfolioAndShare(portfolio, share);
        int totalBought = trades.stream().filter(t -> t.getTradeType().equals("BUY")).mapToInt(Trade::getQuantity).sum();
        int totalSold = trades.stream().filter(t -> t.getTradeType().equals("SELL")).mapToInt(Trade::getQuantity).sum();
        int availableQuantity = totalBought - totalSold;

        if (quantity > availableQuantity) {
            throw new Exception("Insufficient shares to sell");
        }

        Trade trade = new Trade();
        trade.setPortfolio(portfolio);
        trade.setShare(share);
        trade.setQuantity(quantity);
        trade.setTradeType("SELL");

        tradeRepository.save(trade);
    }
}
