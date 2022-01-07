package com.bielecki.BinanceBot;

import com.bielecki.BinanceBot.service.SimpleGetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    SimpleGetServiceImpl simpleGetService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(simpleGetService.requestGet());
    }
}
