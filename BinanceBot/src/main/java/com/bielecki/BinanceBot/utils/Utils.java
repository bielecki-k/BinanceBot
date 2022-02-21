package com.bielecki.BinanceBot.utils;

import org.json.JSONObject;

public class Utils {

    public static float jsonToFloat(String jsonResult){
//        JSONObject json = new JSONObject(jsonResult);
//        String tech = json.getString("price");
//
//        String json2 = new JSONObject(jsonResult).getString("price");

        return Float.parseFloat(new JSONObject(jsonResult).getString("price"));
    }

}
