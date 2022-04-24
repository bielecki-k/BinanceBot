package com.bielecki.BinanceBot.service;

import com.bielecki.BinanceBot.entity.TransactionHist;
import com.bielecki.BinanceBot.repository.TransactionHistCRUDRepository;
import com.bielecki.BinanceBot.utils.Utils;
import com.binance.connector.client.impl.SpotClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class GetPriceAndMakeDecisionServiceImpl implements GetPriceAndMakeDecisionService{

    private static final Logger logger = LoggerFactory.getLogger(GetPriceAndMakeDecisionServiceImpl.class);

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Autowired
    TransactionHistCRUDRepository transactionHistCRUDRepository;

    @Override
    @Scheduled(fixedRate = 3000)
    public void getPriceAndMakeDecision() {
        //get price
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        SpotClientImpl client = new SpotClientImpl();
        parameters.put("symbol", "BTCBUSD");
        String result = client.createMarket().averagePrice(parameters);
        logger.info("new bean: {}", result);

        BigDecimal currentPrice = Utils.jsonToBigDecimalGetPrice(result);

        //get transaction for BTC
        List<TransactionHist> active = transactionHistCRUDRepository.getActive();
        BigDecimal priceAtBuy = active.get(0).getPriceAtBuy();

        logger.info("currentPrice: {} , priceAtBuy: {}",currentPrice,priceAtBuy);
        comparePrices(currentPrice,priceAtBuy);

    }

    private void comparePrices(BigDecimal currentPrice, BigDecimal priceAtBuy) {

        switch (currentPrice.compareTo(priceAtBuy)) {
            case 1 -> {
                logger.info("sell BTC!");
                comparePricesPercentage(currentPrice, priceAtBuy);
            }
            case -1 -> logger.info("hold up");
            default ->  //0 - no difference
                    logger.info("no difference");
        }

    }

    private void comparePricesPercentage(BigDecimal currentPrice, BigDecimal priceAtBuy){
        BigDecimal percentage = currentPrice.divide(priceAtBuy, RoundingMode.HALF_UP).multiply(ONE_HUNDRED);
        logger.info("percentage: {}",percentage);
    }

}
