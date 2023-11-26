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
public class PriceStrategyFactory implements InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;

    private final Map<Integer,PriceStrategy> priceStrategies = new HashMap();

    public PriceStrategy chooseStrategy(Integer userType){

        return priceStrategies.get(userType);
    }
    /*  public static PriceStrategy setStrategy(Integer userType){
        if(userType==2){
            return new StudentPriceStrategy();
        }else if(userType==3){
            return new ChildPriceStrategy();
        }else {
            return new AdultPriceStrategy();
        }

    }*/

    @Override
    public void afterPropertiesSet() throws Exception {

        //get PriceStrage bean from IOC
        Map<String, PriceStrategy> priceStrategyMap = applicationContext.getBeansOfType(PriceStrategy.class);

        //a mapping between user type and priceStrategy
        priceStrategyMap.forEach((key,val)->priceStrategies.put(val.mark(),val));

    }
}
