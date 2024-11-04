package com.evaExchange.eva.component;

import com.evaExchange.eva.entities.Portfolio;
import com.evaExchange.eva.entities.Share;
import com.evaExchange.eva.entities.User;
import com.evaExchange.eva.repository.PortfolioRepository;
import com.evaExchange.eva.repository.ShareRepository;
import com.evaExchange.eva.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

private final UserRepository userRepository;

private final PortfolioRepository portfolioRepository;

private final ShareRepository shareRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUserName("user2");
        userRepository.save(user1);

        Portfolio portfolio1 = new Portfolio();
        portfolio1.setUser(user1);
        portfolioRepository.save(portfolio1);

        Share share1 = new Share();
        share1.setSymbol("BBB");
        share1.setPrice(new BigDecimal("100.00"));
        shareRepository.save(share1);

    }
}
