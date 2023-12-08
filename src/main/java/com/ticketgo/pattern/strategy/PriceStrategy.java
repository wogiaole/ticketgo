package com.ticketgo.pattern.strategy;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class PriceStrategy implements PricedItem {
    private BigDecimal price;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract Integer mark();

    public abstract BigDecimal calculatePrice();
}
