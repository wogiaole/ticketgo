package com.ticketgo.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
public class ChildPriceStrategy extends PriceStrategy{
    //儿童便宜2快
    @Override
    public BigDecimal calculatePrice() {

        log.info("儿童：便宜2块");
        super.setPrice(super.getPrice().subtract(new BigDecimal("2.0")));
        return super.getPrice();

    }
}
