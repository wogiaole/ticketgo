package com.ticketgo.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
public class AdultPriceStrategy extends PriceStrategy{
    //普通不打折
    @Override
    public BigDecimal calculatePrice() {
        log.info("成人：无折扣");
        return super.getPrice();
    }
}
