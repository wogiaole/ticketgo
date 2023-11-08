package com.ticketgo.factory;

import com.ticketgo.strategy.AdultPriceStrategy;
import com.ticketgo.strategy.ChildPriceStrategy;
import com.ticketgo.strategy.PriceStrategy;
import com.ticketgo.strategy.StudentPriceStrategy;

public class PriceStrategyFactory {
    public static PriceStrategy setStrategy(Integer userType){
        if(userType==2){
            return new StudentPriceStrategy();
        }else if(userType==3){
            return new ChildPriceStrategy();
        }else {
            return new AdultPriceStrategy();
        }

    }
}
