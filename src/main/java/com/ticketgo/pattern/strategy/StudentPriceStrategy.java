package com.ticketgo.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class StudentPriceStrategy extends PriceStrategy{

    @Override
    public Integer mark() {
        return 2;
    }

    @Override
    public BigDecimal calculatePrice() {

       log.info("student: 20% off");
        super.setPrice(super.getPrice().multiply(new BigDecimal("0.8")));
        return super.getPrice();
    }
}
