package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by nakoryakov on 05.12.15.
 */
public class Order {
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int result = 0;
        for (Dish dish: dishes){
            result += dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString()
    {
        if (dishes.isEmpty()){
            return "";
        }
        else {
            return "Your order: " + dishes + " of " + tablet.toString();
        }
    }
}
