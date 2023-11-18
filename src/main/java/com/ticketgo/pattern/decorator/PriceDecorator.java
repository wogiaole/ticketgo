package com.ticketgo.pattern.decorator;

import com.ticketgo.pattern.strategy.PriceStrategy;

import java.math.BigDecimal;

public abstract class PriceDecorator extends PriceStrategy{

    private PriceStrategy priceStrategy;
    @Override
    public abstract BigDecimal calculatePrice();
}
