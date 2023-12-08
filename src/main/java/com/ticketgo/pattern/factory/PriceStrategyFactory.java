package com.ticketgo.pattern.factory;

import com.ticketgo.pattern.strategy.AdultPriceStrategy;
import com.ticketgo.pattern.strategy.ChildPriceStrategy;
import com.ticketgo.pattern.strategy.PriceStrategy;
import com.ticketgo.pattern.strategy.StudentPriceStrategy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PriceStrategyFactory{
      public static PriceStrategy chooseStrategy(Integer userType){
        if(userType==2){
            return new StudentPriceStrategy();
        }else if(userType==3){
            return new ChildPriceStrategy();
        }else {
            return new AdultPriceStrategy();
        }

    }
}
