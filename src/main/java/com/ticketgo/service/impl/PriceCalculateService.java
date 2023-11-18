package com.ticketgo.service.impl;

import com.ticketgo.pattern.decorator.BirthdayDecorator;
import com.ticketgo.pattern.decorator.ChristmasDecorator;
import com.ticketgo.entity.Showing;
import com.ticketgo.entity.Ticket;
import com.ticketgo.entity.User;
import com.ticketgo.pattern.factory.PriceStrategyFactory;
import com.ticketgo.service.ShowingService;
import com.ticketgo.service.UserService;
import com.ticketgo.pattern.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

/**
 * 订票后，价格计算
 */
@Service
@Slf4j
public class PriceCalculateService {
    @Autowired
    private UserService userService;
    @Autowired
    private ShowingService showingService;
    @Autowired
    private PriceStrategyFactory priceStrategyFactory;

    //check if today is birthday
    public boolean isBirthday(LocalDate birthDate) {
        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 检查生日是否是今天
        return today.getMonth() == birthDate.getMonth() && today.getDayOfMonth() == birthDate.getDayOfMonth();
    }

    //check if today is Christmas
    public boolean isChristmas() {
        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 检查是否是圣诞节（12月25日）
        return today.getMonth() == Month.DECEMBER && today.getDayOfMonth() == 25;

    }

    //calculate final price
    public BigDecimal calculatePrice(Ticket ticket){

        User user = userService.getById(ticket.getUserId());
        Showing showing = showingService.getById(ticket.getShowingId());

        //1. factory, strategy: Set price strategy based on user type
        PriceStrategy priceStrategy1 = priceStrategyFactory.chooseStrategy(user.getType());
        ticket.setPriceStrategy(priceStrategy1);
        //get price after applying strategy
        BigDecimal price = showing.getPrice();
        log.info("The original price is:{}",price);
        ticket.getPriceStrategy().setPrice(price);

        //2. Decorator: calculate discount based on holidays
        PriceStrategy priceStrategy = ticket.getPriceStrategy();

        //if Christmas discount
        if(isChristmas()){
          //  log.info("Christmas");

            priceStrategy = new ChristmasDecorator(priceStrategy);
        }
        //if birthday discount
        if(isBirthday(user.getBirthday())){
          //  log.info("Birthday);
            priceStrategy = new BirthdayDecorator(priceStrategy);
        }


        BigDecimal cost = priceStrategy.calculatePrice();
        return cost;
    }

}
