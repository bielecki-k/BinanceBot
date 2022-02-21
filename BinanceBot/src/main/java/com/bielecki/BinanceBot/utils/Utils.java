package com.bielecki.BinanceBot.utils;

import org.json.JSONObject;

public class Utils {

    public static float jsonToFloat(String jsonResult){
        return Float.parseFloat(new JSONObject(jsonResult).getString("price"));
    }

}
