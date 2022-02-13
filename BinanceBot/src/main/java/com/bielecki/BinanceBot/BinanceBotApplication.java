package com.bielecki.BinanceBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinanceBotApplication {


	private static final Logger logger = LoggerFactory.getLogger(BinanceBotApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BinanceBotApplication.class, args);

		System.out.println("lecim");

	}




//	private static void extracted() { //binance simple get price
//		LinkedHashMap<String,Object> parameters = new LinkedHashMap<>();
//
//		SpotClientImpl client = new SpotClientImpl();
//
//		parameters.put("symbol","BTCBUSD");
//		String result = client.createMarket().averagePrice(parameters);
//		logger.info(result);
//	}


}
