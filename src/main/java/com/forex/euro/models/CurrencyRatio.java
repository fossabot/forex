package com.forex.euro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRatio {

    private CurrencyEnum fromCurrency;
    private CurrencyEnum toCurrency;
    double ratio;
}
