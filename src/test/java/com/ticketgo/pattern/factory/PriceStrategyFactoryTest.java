package com.ticketgo.pattern.factory;

import com.ticketgo.pattern.strategy.AdultPriceStrategy;
import com.ticketgo.pattern.strategy.ChildPriceStrategy;
import com.ticketgo.pattern.strategy.PriceStrategy;
import com.ticketgo.pattern.strategy.StudentPriceStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceStrategyFactoryTest {
    @Test
    void chooseStrategy_Stu() {
        // 调用chooseStrategy方法，传入用户类型2
        PriceStrategy strategy = PriceStrategyFactory.chooseStrategy(2);

        // 验证返回的PriceStrategy对象是否是StudentPriceStrategy的实例
        assertTrue(strategy instanceof StudentPriceStrategy, "用户类型为2时应返回StudentPriceStrategy");
    }

    @Test
    void chooseStrategy_Children() {
        // 调用chooseStrategy方法，传入用户类型3
        PriceStrategy strategy = PriceStrategyFactory.chooseStrategy(3);

        // 验证返回的PriceStrategy对象是否是ChildPriceStrategy的实例
        assertTrue(strategy instanceof ChildPriceStrategy, "用户类型为3时应返回ChildPriceStrategy");
    }

    @Test
    void chooseStrategy_Adult() {
        // 调用chooseStrategy方法，传入其他用户类型
        PriceStrategy strategy = PriceStrategyFactory.chooseStrategy(1);

        // 验证返回的PriceStrategy对象是否是AdultPriceStrategy的实例
        assertTrue(strategy instanceof AdultPriceStrategy, "其他用户类型时应返回AdultPriceStrategy");
    }
}