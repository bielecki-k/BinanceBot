package com.bielecki.BinanceBot.component;

import com.bielecki.BinanceBot.service.GetAndSaveServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTasks { //left for test impl

    private static final Logger logger = LoggerFactory.getLogger(GetAndSaveServiceImpl.class);

//    @Scheduled(fixedRate = 10000) // todo remove to Starter class?
//    public void scheduleTaskFixedRate(){
//        logger.info("scheduleTaskFixedRate executed at {}", LocalDateTime.now());
//    }

}
