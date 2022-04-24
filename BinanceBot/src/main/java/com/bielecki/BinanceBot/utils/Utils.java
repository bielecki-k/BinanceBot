package com.bielecki.BinanceBot.utils;

import org.json.JSONObject;

import java.math.BigDecimal;

public class Utils {

    public static BigDecimal jsonToBigDecimalGetPrice(String jsonResult){
        return new BigDecimal(new JSONObject(jsonResult).getString("price"));
    }

}
