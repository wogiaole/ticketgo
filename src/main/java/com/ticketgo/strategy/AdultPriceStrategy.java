package com.ticketgo.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class AdultPriceStrategy extends PriceStrategy{

    @Override
    public Integer mark() {
        return 1;
    }

    //成人票不打折
    @Override
    public BigDecimal calculatePrice() {
        log.info("adult: no discount");
        return super.getPrice();
    }
}
