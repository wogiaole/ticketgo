package com.ticketgo.service.util;

import com.ticketgo.decorator.BirthdayDecorator;
import com.ticketgo.decorator.ChristmasDecorator;
import com.ticketgo.entity.Showing;
import com.ticketgo.entity.Ticket;
import com.ticketgo.entity.User;
import com.ticketgo.factory.PriceStrategyFactory;
import com.ticketgo.service.ShowingService;
import com.ticketgo.service.UserService;
import com.ticketgo.strategy.PriceStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@Slf4j
public class PriceCalculateService {
    @Autowired
    private UserService userService;
    @Autowired
    private ShowingService showingService;

    public boolean isBirthday(LocalDate birthDate) {
        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 检查生日是否是今天
        return today.getMonth() == birthDate.getMonth() && today.getDayOfMonth() == birthDate.getDayOfMonth();
    }

    public boolean isChristmas() {
        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 检查是否是圣诞节（12月25日）
        return today.getMonth() == Month.DECEMBER && today.getDayOfMonth() == 25;

    }

    public BigDecimal calculatePrice(Ticket ticket){

        User user = userService.getById(ticket.getUserId());
        Showing showing = showingService.getById(ticket.getShowingId());

        //设置价格
        //1. 工厂模式+策略模式：基于用户类型，设置价格策略类型
        ticket.setPriceStrategy(PriceStrategyFactory.setStrategy(user.getType()));
        //注入原价

        BigDecimal price = showing.getPrice();
        log.info("原价为：{}",price);
        ticket.getPriceStrategy().setPrice(price);

        //2. 装饰器模式：根据节日，叠加计算优惠
        PriceStrategy priceStrategy = ticket.getPriceStrategy();

        //圣诞节优惠
        if(isChristmas()){
          //  log.info("圣诞");
            //如果当天圣诞节
            priceStrategy = new ChristmasDecorator(priceStrategy);
        }
        //生日优惠
        if(isBirthday(user.getBirthday())){
          //  log.info("生日");
            //如果当天生日
            priceStrategy = new BirthdayDecorator(priceStrategy);
        }

        BigDecimal cost = priceStrategy.calculatePrice();
        return cost;
    }

}
