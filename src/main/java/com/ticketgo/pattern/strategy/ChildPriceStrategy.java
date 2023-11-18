package com.ticketgo.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component//由springboot管理
public class ChildPriceStrategy extends PriceStrategy{
    @Override
    public Integer mark() {
        return 3;
    }

    //儿童便宜2快
    @Override
    public BigDecimal calculatePrice() {

        log.info("child: reduce 2");
        super.setPrice(super.getPrice().subtract(new BigDecimal("2.0")));
        return super.getPrice();



    }
}
