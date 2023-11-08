package com.ticketgo.decorator;

import com.ticketgo.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class BirthdayDecorator extends PriceDecorator {
    private static final int COST = 1;
    private PriceStrategy priceStrategy;

    public BirthdayDecorator(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    //生日打五折
    @Override
    public BigDecimal calculatePrice() {
        log.info("生日：打五5折");
        BigDecimal afterPrice = priceStrategy.calculatePrice().multiply(new BigDecimal("0.5"));
        priceStrategy.setPrice(afterPrice);
        return afterPrice;
    }
}
