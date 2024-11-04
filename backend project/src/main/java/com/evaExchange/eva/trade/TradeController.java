package com.evaExchange.eva.trade;

import com.evaExchange.eva.model.TradeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ap/trades" )
@RestController
public interface TradeController {
    @PostMapping("/buy")
    ResponseEntity<String> buy(@RequestBody TradeRequest tradeReguest);
    @PostMapping("/sell")
    ResponseEntity<String> sell(@RequestBody TradeRequest tradeReguest);
}
