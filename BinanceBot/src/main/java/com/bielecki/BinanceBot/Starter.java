package com.bielecki.BinanceBot;

import com.bielecki.BinanceBot.service.GetPriceAndMakeDecisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Starter implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BinanceBotApplication.class);

//    @Autowired //depreciated
//    GetAndSaveService getAndSaveService;

    @Autowired
    GetPriceAndMakeDecisionService getPriceAndMakeDecisionService;

    @Override
    @Transactional
    public void run(String... args) {
//        getAndSaveService.getAndSavePrice();
//        getAndSaveService.getActiveTransactions();

    }

//    private static void extracted() { //binance simple get price
//        LinkedHashMap<String,Object> parameters = new LinkedHashMap<>();
//
//        SpotClientImpl client = new SpotClientImpl();
//
//        parameters.put("symbol","BTCBUSD");
//        String result = client.createMarket().averagePrice(parameters);
//        logger.info(result);
//    }
}
