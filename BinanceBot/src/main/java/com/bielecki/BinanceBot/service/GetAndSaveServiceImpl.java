package com.bielecki.BinanceBot.service;

import com.bielecki.BinanceBot.BinanceBotApplication;
import com.bielecki.BinanceBot.entity.PriceHist;
import com.bielecki.BinanceBot.repository.PriceHistCRUDRepository;
import com.binance.connector.client.impl.SpotClientImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

@Service
public class GetAndSaveServiceImpl implements GetAndSaveService{

    private static final Logger logger = LoggerFactory.getLogger(GetAndSaveServiceImpl.class);

    @Autowired
    PriceHistCRUDRepository priceHistCRUDRepository;

    @Override
    public void getAndSavePrice() {
        logger.info("service getAndSavePrice");

        //get price
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        SpotClientImpl client = new SpotClientImpl();
        parameters.put("symbol", "BTCBUSD");
        String result = client.createMarket().averagePrice(parameters);
        logger.info("bean: {}", result);
        jsonToFloat(result);

        //save to DB
        priceHistCRUDRepository.save(new PriceHist("BTCBUSD",new Timestamp(System.currentTimeMillis()),12));
    }

    private void jsonToFloat(String jsonResult){

        JSONObject json = new JSONObject(jsonResult);
        String tech = json.getString("price");

        logger.info("jsonToFloat: {}",tech);
    }
}
