package com.ticketgo.pattern.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PayInvokerTest {
    @Test
    void executePayment() {
        // 创建PayInvoker对象
        PayInvoker payInvoker = new PayInvoker();

        // 尝试设置未知的支付方法
        try {
            payInvoker.setPayCommand(999);
        } catch (IllegalArgumentException e) {
            // 验证是否抛出了IllegalArgumentException
            assert ("Unknown payment method: 999".equals(e.getMessage()));
        }

        // 尝试执行未设置PayCommand的executePayment()方法
        try {
            payInvoker.executePayment();
        } catch (IllegalStateException e) {
            // 验证是否抛出了IllegalStateException
            assert ("Pay command not set".equals(e.getMessage()));
        }
    }
}
