package com.ticketgo.mapper;

import com.ticketgo.service.status.Status;
import com.ticketgo.service.status.impl.CanceledStatus;
import com.ticketgo.service.status.impl.CompletedStatus;
import com.ticketgo.service.status.impl.PaidStatus;
import com.ticketgo.service.status.impl.UnpaidStatus;

public class StatusMapper {
    public static Status mapIntToStatus(int status) {
        switch (status) {
            case 1: // 0 represents unpaid status
                return new UnpaidStatus();
            case 2: // 1 represents paid status
                return new PaidStatus();
            case 3: // 2 represents cancelled status
                return new CompletedStatus();
            case 4: // 2 represents cancelled status
                return new CanceledStatus();
            // Add more cases for other status values as needed
            default:
                throw new IllegalArgumentException("Invalid status value: " + status);
        }
    }

    public static int mapStatusToInt(Status status) {
        if (status instanceof UnpaidStatus) {
            return 0;
        } else if (status instanceof PaidStatus) {
            return 1;
        } else if (status instanceof CanceledStatus) {
            return 2;
            // Add more cases for other status types as needed
        } else {
            throw new IllegalArgumentException("Unsupported status type: " + status.getClass().getName());
        }
    }
}



