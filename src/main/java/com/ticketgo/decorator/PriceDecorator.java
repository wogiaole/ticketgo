package com.ticketgo.decorator;

import com.ticketgo.strategy.PriceStrategy;

import java.math.BigDecimal;

public abstract class PriceDecorator extends PriceStrategy{

    private PriceStrategy priceStrategy;
    @Override
    public abstract BigDecimal calculatePrice();
}
