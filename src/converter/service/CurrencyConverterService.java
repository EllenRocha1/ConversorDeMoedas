package java.service;

import java.api.ExchangeRateClient;

public class CurrencyConverterService {

    public static double convert(String from, String to, double amount) throws Exception {
        double rate = ExchangeRateClient.getExchangeRate(from, to);
        return amount * rate;
    }
}