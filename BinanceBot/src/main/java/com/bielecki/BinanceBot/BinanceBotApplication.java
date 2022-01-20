package com.bielecki.BinanceBot;

import com.binance.connector.client.impl.SpotClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;

@SpringBootApplication
public class BinanceBotApplication {

	private static final Logger logger = LoggerFactory.getLogger(BinanceBotApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BinanceBotApplication.class, args);

//		ConfigurableApplicationContext applicationContext =  SpringApplication.run(BinanceBotApplication.class, args);

		LinkedHashMap<String,Object> parameters = new LinkedHashMap<>();

		SpotClientImpl client = new SpotClientImpl();

		parameters.put("symbol","BNBUSDT");
		String result = client.createMarket().averagePrice(parameters);
		logger.info(result);


	}



}
