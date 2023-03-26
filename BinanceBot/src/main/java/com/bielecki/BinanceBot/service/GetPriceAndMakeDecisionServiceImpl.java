package com.bielecki.BinanceBot.service;

import com.bielecki.BinanceBot.entity.SellBuyChance;
import com.bielecki.BinanceBot.entity.TransactionHist;
import com.bielecki.BinanceBot.repository.SellBuyChanceCRUDRepository;
import com.bielecki.BinanceBot.repository.TransactionHistCRUDRepository;
import com.bielecki.BinanceBot.utils.Utils;
import com.binance.connector.client.impl.SpotClientImpl;
//import com.sanctionco.jmail.JMail;
//import com.sanctionco.jmail.TopLevelDomain;
//import org.simplejavamail.api.email.Email;
//import org.simplejavamail.api.mailer.Mailer;
//import org.simplejavamail.api.mailer.config.TransportStrategy;
//import org.simplejavamail.email.EmailBuilder;
//import org.simplejavamail.mailer.MailerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class GetPriceAndMakeDecisionServiceImpl implements GetPriceAndMakeDecisionService{

    private static final Logger logger = LoggerFactory.getLogger(GetPriceAndMakeDecisionServiceImpl.class);

    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Autowired
    TransactionHistCRUDRepository transactionHistCRUDRepository;

    @Autowired
    SellBuyChanceCRUDRepository sellBuyChanceCRUDRepository;

    @Override
    @Scheduled(fixedRate = 3000)
    public void getPriceAndMakeDecision() {
        //get price
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        SpotClientImpl client = new SpotClientImpl();
        parameters.put("symbol", "BTCBUSD");
        String result = client.createMarket().averagePrice(parameters);
        logger.info("new bean: {}", result);

        BigDecimal currentPrice = Utils.jsonToBigDecimalGetPrice(result);

        //get transaction for BTC
        List<TransactionHist> active = transactionHistCRUDRepository.getActive();
        BigDecimal priceAtBuy = active.get(0).getPriceAtBuy();

        logger.info("currentPrice: {} , priceAtBuy: {}",currentPrice,priceAtBuy);
        comparePrices(currentPrice,priceAtBuy);


//        email.sendEmail();
//        emailSend();
        SellBuyChance sellBuyChance = new SellBuyChance();
        sellBuyChance.setChance_timestamp(Instant.now());
        sellBuyChance.setPrice_at_chance(BigDecimal.valueOf(22.22));
        sellBuyChance.setTransaction_hist_id(1);

        sellBuyChanceCRUDRepository.save(sellBuyChance);




    }

//    private static void emailSend() {
//        try {
//            Email email = EmailBuilder.startingBlank()
//                    .from("lollypop", "lolly.pop@pretzelfun.com")
//                    .to("C. Cane", "keru@protonmail.com")
////                .cc("C. Bo <chocobo@candyshop.org>")
//                    .withSubject("hey")
//                    .withPlainText("We should meet up! ;)")
//                    .buildEmail();
//
//            Mailer mailer = MailerBuilder
//                    .withSMTPServer("smtp-mail.outlook.com", 587, "binancebotexch@outlook.com", "objective51.")
//                    .withTransportStrategy(TransportStrategy.SMTP_TLS)
////                .withProxy("socksproxy.host.com", 1080, "proxy user", "proxy password")
//                    .withSessionTimeout(10 * 1000)
//                    .clearEmailValidator() // turns off email validation
////                .withEmailValidator( // or not
////                        JMail.strictValidator()
////                                .requireOnlyTopLevelDomains(TopLevelDomain.DOT_COM)
////                                .withRule(email -> email.localPart().startsWith("allowed")))
//                    .withProperty("mail.smtp.sendpartial", true)
//                    .withDebugLogging(true)
//                    .async()
//                    .buildMailer();
//
//            mailer.sendMail(email);
//        }catch(Exception e){
//            logger.info("email send exc: ",e);
//        }
//
//    }

    private void comparePrices(BigDecimal currentPrice, BigDecimal priceAtBuy) {

        switch (currentPrice.compareTo(priceAtBuy)) {
            case 1 -> {
                logger.info("sell BTC!");
                comparePricesPercentage(currentPrice, priceAtBuy);
            }
            case -1 -> logger.info("hold up");
            default ->  //0 - no difference
                    logger.info("no difference");
        }

    }

    private void comparePricesPercentage(BigDecimal currentPrice, BigDecimal priceAtBuy){
        BigDecimal percentage = currentPrice.divide(priceAtBuy, RoundingMode.HALF_UP).multiply(ONE_HUNDRED);
        logger.info("percentage: {}",percentage);
    }

}
