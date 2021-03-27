package com.forex.euro.controller;

import com.forex.euro.models.CurrencyEnum;
import com.forex.euro.models.CurrencyRatio;
import com.forex.euro.models.Forex;
import com.forex.euro.repository.ForexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ECBController {

        public CurrencyRatio getCurrencyRatio(CurrencyEnum fromCur, CurrencyEnum toCur,ForexRepository forexRepository) {
                Forex fromCurrRefEuro = new FeedController().getFeedContent(fromCur);
                updateRequestCount(fromCurrRefEuro,forexRepository);
                Forex toCurrRefEuro = new FeedController().getFeedContent(toCur);
                updateRequestCount(toCurrRefEuro,forexRepository);
                double ratio = toCurrRefEuro.getExchangeRate()/fromCurrRefEuro.getExchangeRate();

                return new CurrencyRatio(fromCur,toCur,ratio);
        }

        public Forex updateRequestCount(Forex forex, ForexRepository forexRepository){
                Optional<Forex> savedForex = forexRepository.findAll().stream().filter(f -> f.getCurrency().equals(forex.getCurrency())).findAny();
                if(!savedForex.isPresent()){
                        Forex newForex = forexRepository.save(forex);
                        return newForex;
                }else{
                        savedForex.get().setRequested(savedForex.get().getRequested()+1);
                        Forex updatedForex = forexRepository.save(savedForex.get());
                        return updatedForex;
                }
        }
}
