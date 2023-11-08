package com.ticketgo.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class StudentPriceStrategy extends PriceStrategy{

    @Override
    public BigDecimal calculatePrice() {

        log.info("学生：打8折");
        super.setPrice(super.getPrice().multiply(new BigDecimal("0.8")));
        return super.getPrice();
    }
}
