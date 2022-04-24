package com.bielecki.BinanceBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableJpaRepositories
@SpringBootApplication
@EnableScheduling
public class BinanceBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BinanceBotApplication.class, args);
	}

	//todo i jak engine znajdzie okazje by sprzedac bo zdrozalo lub jak spadnie o 10% to wyslac informacje do serwisu od kupowania/sprzedawania
	//todo i na tym mozna by zakonczyc
	//todo ewentualnie poprawic lacznie z API Binance - zeby laczylo sie z moim kontem i bylo w stanie cos kupic/sprzedac
	//w sumie to bedzie zakonczone glowne zalozenie projektu

}
