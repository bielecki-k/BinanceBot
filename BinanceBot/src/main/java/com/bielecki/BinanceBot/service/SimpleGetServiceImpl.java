package com.bielecki.BinanceBot.service;

import com.bielecki.BinanceBot.configuration.PrivateBinanceConfig;
import com.binance.connector.client.enums.DefaultUrls;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.WebsocketClientImpl;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SimpleGetServiceImpl {


    public String requestGet() {
        return "hello world";
    }

    public void makeRequest() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

//            HttpGet request = new HttpGet("https://api.bitbay.net/rest/trading/stats/BTC-PLN");
            HttpGet request = new HttpGet("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");

            // add request headers
//            request.addHeader("custom-key", "example1");
//            request.addHeader(HttpHeaders.USER_AGENT, "example2");

            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                System.out.println(response.getProtocolVersion());              // HTTP/1.1
                System.out.println(response.getStatusLine().getStatusCode());   // 200
                System.out.println(response.getStatusLine().getReasonPhrase()); // OK
                System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }

    public void connector(){
        WebsocketClientImpl wsClient = new WebsocketClientImpl(DefaultUrls.TESTNET_WSS_URL);
        SpotClientImpl spotClient = new SpotClientImpl(PrivateBinanceConfig.TESTNET_API_KEY, PrivateBinanceConfig.TESTNET_SECRET_KEY, DefaultUrls.TESTNET_URL);
        JSONObject obj = new JSONObject(spotClient.createUserData().createListenKey());
        String listenKey = obj.getString("listenKey");
        System.out.println("listenKey:" + listenKey);
        wsClient.listenUserStream(listenKey, ((event) -> {
            System.out.println(event);
            wsClient.closeAllConnections();
        }));
    }
}
