package com.ticketgo.pattern.strategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StudentPriceStrategyTest {
    @Test
    void calculatePrice() {
        //原价100 该打折80
        StudentPriceStrategy studentPriceStrategy = new StudentPriceStrategy();
        studentPriceStrategy.setPrice(new BigDecimal("100")); // 设置初始价格

        BigDecimal discountedPrice = studentPriceStrategy.calculatePrice();

        assertEquals(new BigDecimal("80"), discountedPrice);
    }
}