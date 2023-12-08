package com.ticketgo.pattern.observer;

public interface Observer {
    void update(String movieName);
    String getEmail();
    String getUserName();
    //void update(String message);
}
