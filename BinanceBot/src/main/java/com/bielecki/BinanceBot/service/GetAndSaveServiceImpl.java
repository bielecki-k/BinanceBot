package com.bielecki.BinanceBot.service;

import com.bielecki.BinanceBot.entity.PriceHist;
import com.bielecki.BinanceBot.repository.PriceHistCRUDRepository;
import com.bielecki.BinanceBot.utils.Utils;
import com.binance.connector.client.impl.SpotClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.LinkedHashMap;

@Service
public class GetAndSaveServiceImpl implements GetAndSaveService{

    private static final Logger logger = LoggerFactory.getLogger(GetAndSaveServiceImpl.class);

    @Autowired
    PriceHistCRUDRepository priceHistCRUDRepository;

    @Override
    @Scheduled(fixedRate = 3000)
    public void getAndSavePrice() {
        //get price
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        SpotClientImpl client = new SpotClientImpl();
        parameters.put("symbol", "BTCBUSD");
        String result = client.createMarket().averagePrice(parameters);
        logger.info("bean: {}", result);

        //save to DB
        priceHistCRUDRepository.save(new PriceHist("BTCBUSD",new Timestamp(System.currentTimeMillis()),Utils.jsonToFloat(result)));
    }


}
