package com.ticketgo.pattern.decorator;

import com.ticketgo.pattern.strategy.PriceStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChristmasDecoratorTest {

    @Test
    void mark() {
    }

    @Test
    void calculatePrice_shouldBe50Percent() {
        // 创建一个模拟的PriceStrategy
        PriceStrategy mockPriceStrategy = mock(PriceStrategy.class);

        // 设置模拟的PriceStrategy在calculatePrice()方法调用时返回一个特定的价格
        BigDecimal originalPrice = new BigDecimal("100.00");
        when(mockPriceStrategy.calculatePrice()).thenReturn(originalPrice);

        // 创建BirthdayDecorator，并传入模拟的PriceStrategy
        BirthdayDecorator chrismasDecorator = new BirthdayDecorator(mockPriceStrategy);

        // 调用calculatePrice()方法，获取生日折扣后的价格
        BigDecimal discountedPrice = chrismasDecorator.calculatePrice();

        // 验证折扣是否正确应用
        BigDecimal expectedDiscountedPrice = originalPrice.multiply(new BigDecimal("0.5"));
        assertEquals(expectedDiscountedPrice, discountedPrice, "圣诞折扣应正确应用");
    }
}