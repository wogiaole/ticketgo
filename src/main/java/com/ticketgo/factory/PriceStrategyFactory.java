package com.ticketgo.factory;

import com.ticketgo.strategy.AdultPriceStrategy;
import com.ticketgo.strategy.ChildPriceStrategy;
import com.ticketgo.strategy.PriceStrategy;
import com.ticketgo.strategy.StudentPriceStrategy;
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


    public static PriceStrategy setStrategy(Integer userType){
        if(userType==2){
            return new StudentPriceStrategy();
        }else if(userType==3){
            return new ChildPriceStrategy();
        }else {
            return new AdultPriceStrategy();
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //从IOC中获取PriceStrage类型的bean对象
        Map<String, PriceStrategy> priceStrategyMap = applicationContext.getBeansOfType(PriceStrategy.class);

        //
        priceStrategyMap.forEach((key,val)->priceStrategies.put(val.mark(),val));

    }
}
