package com.bielecki.BinanceBot.configuration;

import com.bielecki.BinanceBot.entity.PriceHist;
import com.bielecki.BinanceBot.repository.PriceHistCRUDRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.sql.Timestamp;
import java.util.List;


@Configuration
@EnableTransactionManagement
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public CommandLineRunner demoCRUD(PriceHistCRUDRepository repository) {
        return (args) -> {
            // save a new price
            repository.save(new PriceHist(1L,"nn",new Timestamp(System.currentTimeMillis()),12));
            repository.save(new PriceHist("xx",new Timestamp(System.currentTimeMillis()),12));


            // fetch all customers
            logger.info("PriceHist found with findAll():");
            logger.info("-------------------------------");
            for (PriceHist priceHist : repository.findAll()) {
                logger.info(priceHist.toString());
            }
            logger.info("");

            // fetch an individual priceHist by name
            List<PriceHist> priceHist = repository.findPriceBycurencyName("nn");
            logger.info("PriceHist found with findPriceBycurencyName(nn):");
            logger.info("--------------------------------");
            logger.info(priceHist.toString());
            logger.info("");


        };
    }


}
