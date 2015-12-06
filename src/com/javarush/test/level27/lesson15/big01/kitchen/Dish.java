package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by nakoryakov on 05.12.15.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        String result = "";
        for (Dish dish: values())
            result += dish + ", ";
        return result.substring(0, result.length() - 2);
    }
}
