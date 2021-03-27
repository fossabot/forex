package com.forex.euro.controller;

import com.forex.euro.models.CurrencyEnum;
import com.forex.euro.models.Forex;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedController {

    public Forex getFeedContent(CurrencyEnum currency) {
        Forex forex = new Forex();
        forex.setCurrency(currency.name());
        forex.setRequested(0);
        if(currency.toString() == "EUR"){
            forex.setExchangeRate(1.0);
        }else{

            try {
                URL feedSource = null;
                feedSource = new URL("https://www.ecb.europa.eu/rss/fxref-" + currency.toString().toLowerCase() + ".html");
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = null;
                feed = input.build(new XmlReader(feedSource));
                forex.setExchangeRate(Double.parseDouble(feed.getEntries().get(0).getTitle().substring(0, 6)));
            } catch (FeedException | IOException e) {
                e.printStackTrace();
            }
        }
        return forex;
    }
}
