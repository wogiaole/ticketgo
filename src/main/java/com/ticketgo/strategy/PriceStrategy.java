package com.ticketgo.strategy;

import java.math.BigDecimal;

public abstract class PriceStrategy {
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract BigDecimal calculatePrice();
}
