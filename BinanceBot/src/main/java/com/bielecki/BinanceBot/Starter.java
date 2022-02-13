package com.bielecki.BinanceBot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Starter implements CommandLineRunner {

    @Override
    @Transactional
    public void run(String... args) throws Exception {


    }
}
