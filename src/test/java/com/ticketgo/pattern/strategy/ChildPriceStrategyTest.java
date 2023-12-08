package com.ticketgo.pattern.strategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ChildPriceStrategyTest {

    @Test
    void calculatePrice() {
        //原价100 该打折80
        ChildPriceStrategy childPriceStrategy = new ChildPriceStrategy();
        childPriceStrategy.setPrice(new BigDecimal("100")); // 设置初始价格

        BigDecimal discountedPrice = childPriceStrategy.calculatePrice();
        assertEquals(new BigDecimal("80"), discountedPrice);
    }
}