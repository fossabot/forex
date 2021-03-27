package com.forex.euro.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CurrencyExchange {
    public Double fromAmount;
    public CurrencyEnum fromCurrencyEnum;
    public CurrencyEnum toCurrencyEnum;
}
