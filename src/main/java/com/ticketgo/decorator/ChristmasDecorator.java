package com.ticketgo.decorator;

import com.ticketgo.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class ChristmasDecorator extends PriceDecorator {
    private static final int COST = 3;
    private PriceStrategy priceStrategy;

    public ChristmasDecorator(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    //圣诞节打八折
    @Override
    public BigDecimal calculatePrice() {
        log.info("圣诞节：打8折");
        BigDecimal afterPrice = priceStrategy.calculatePrice().multiply(new BigDecimal("0.8"));
        priceStrategy.setPrice(afterPrice);
        return afterPrice;
    }
}
