package com.forex.euro.view;

import com.forex.euro.controller.ECBController;
import com.forex.euro.models.CurrencyEnum;
import com.forex.euro.models.CurrencyRatio;
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
public class ExchangePair {
    @Autowired
    ForexRepository forexRepository;

    @GetMapping(value = "/exchangePair")
    public ResponseEntity<CurrencyRatio> getExchange(@RequestParam(name = "fromCur") CurrencyEnum fromCur, @RequestParam(name = "toCur") CurrencyEnum toCur){
        log.info("Received from currency: "+fromCur + " To currency: "+toCur);
        CurrencyRatio currencyRatio = new ECBController().getCurrencyRatio(fromCur,toCur, forexRepository);
        return  new ResponseEntity<>(currencyRatio,HttpStatus.OK);
    }

    @GetMapping(value = "/interactiveChart")
    public String getInteractiveChart(@RequestParam (name = "fromCur") CurrencyEnum fromCur, @RequestParam (name = "toCur") CurrencyEnum toCur){
        log.info("Received from currency: "+fromCur + " To currency: "+toCur);
        return "";
    }
}
