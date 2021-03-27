package com.forex.euro.view;

import com.forex.euro.controller.ECBController;
import com.forex.euro.models.CurrencyExchange;
import com.forex.euro.models.CurrencyRatio;
import com.forex.euro.models.Forex;
import com.forex.euro.repository.ForexRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@Slf4j
@Service
@RestController
@RequestMapping(value = "/euroref")
public class CurrencyService {
    @Autowired
    ForexRepository forexRepository;

    @GetMapping(value = "/currencyInUse")
    public String allCurrencyInUse(){
        log.info("Currency in use are called");
        ArrayList<Forex> forexes = new ArrayList<>();
        Gson gson = new Gson();

        forexes.addAll(forexRepository.findAll());
        return gson.toJson(forexes);
    }

    @GetMapping(value = "/currencyExchange")
    public String convertToOtherCurrency(@RequestBody CurrencyExchange toExchange){
        log.info("Currency Exchange is tracked"+ toExchange.fromCurrencyEnum);

        CurrencyRatio currencyRatio = new ECBController().getCurrencyRatio(toExchange.fromCurrencyEnum, toExchange.toCurrencyEnum,forexRepository);
        log.info("currency ratio: "+currencyRatio.getRatio());
        double currencyConvert=currencyRatio.getRatio() * toExchange.fromAmount;

        return  Double.toString(currencyConvert);
    }
}
