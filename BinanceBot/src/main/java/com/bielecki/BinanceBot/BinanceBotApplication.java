package com.bielecki.BinanceBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BinanceBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinanceBotApplication.class, args);

		ConfigurableApplicationContext applicationContext =  SpringApplication.run(BinanceBotApplication.class, args);


	}



}
