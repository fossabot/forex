package com.forex.euro.view;

import com.forex.euro.controller.ECBController;
import com.forex.euro.controller.FeedController;
import com.forex.euro.models.CurrencyEnum;
import com.forex.euro.models.Forex;
import com.forex.euro.repository.ForexRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping(value = "/euroref")
public class EuroReference {
    @Autowired
    private ForexRepository forexRepository;

    @GetMapping(value = "/exchange")
    public ResponseEntity<Forex> exchangeReference(@RequestParam("currency") CurrencyEnum currency){
        log.info("Received currency"+currency);
        Forex forex = new FeedController().getFeedContent(currency);
        log.info("Forex content is:"+forex.getExchangeRate());
        Forex forexUpdated = new ECBController().updateRequestCount(forex, forexRepository);
        return new ResponseEntity<Forex>(forexUpdated, HttpStatus.OK);
    }
}
