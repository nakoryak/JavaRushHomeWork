package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nakoryakov on 05.12.15.
 */
public class Cook extends Observable implements Observer {
    private String name;
    private Order order;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        order = (Order)arg;
        ConsoleHelper.writeMessage("Start cooking - " + arg.toString() + ", cooking time " + order.getTotalCookingTime() + "min");

        AdvertisementManager am = new AdvertisementManager(order.getTotalCookingTime() * 60);
        am.processVideos();
        setChanged();
        notifyObservers(order);
    }
}
