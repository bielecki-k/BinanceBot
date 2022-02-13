package com.bielecki.BinanceBot;

import com.bielecki.BinanceBot.service.GetAndSaveService;
import com.binance.connector.client.impl.SpotClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.LinkedHashMap;

@Component
public class Starter implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BinanceBotApplication.class);

    @Autowired
    GetAndSaveService getAndSaveService;

    @Override
    @Transactional
    public void run(String... args) {
        getAndSaveService.getAndSavePrice();

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
