package com.ticketgo.pattern.observer;

public interface Subject {

    public void addObserver(Observer observer);
    public void notifyObserver(String msg);
}
