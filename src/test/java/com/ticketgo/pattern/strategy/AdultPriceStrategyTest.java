package com.ticketgo.pattern.strategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AdultPriceStrategyTest {

    @Test
    void calculatePrice() {
        //原价100 不动
        AdultPriceStrategy adultPriceStrategy = new AdultPriceStrategy();
        adultPriceStrategy.setPrice(new BigDecimal("100")); // 设置初始价格

        BigDecimal discountedPrice = adultPriceStrategy.calculatePrice();
        assertEquals(new BigDecimal("100"), discountedPrice);
    }
}