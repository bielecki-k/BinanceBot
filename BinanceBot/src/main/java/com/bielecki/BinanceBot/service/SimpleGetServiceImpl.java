package com.bielecki.BinanceBot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SimpleGetServiceImpl {


    public String requestGet() {
        return "hello world";
    }
}
