package com.ticketgo.pattern.decorator;

import com.ticketgo.pattern.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class BirthdayDecorator extends PriceDecorator {
   // private static final int COST = 1;
    private PriceStrategy priceStrategy;

    public BirthdayDecorator(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    @Override
    public Integer mark() {
        return null;
    }

    //生日打五折
    @Override
    public BigDecimal calculatePrice() {
        log.info("Birthday: 50% off");
        BigDecimal afterPrice = priceStrategy.calculatePrice().multiply(new BigDecimal("0.5"));
        priceStrategy.setPrice(afterPrice);
        return afterPrice;
    }
}
