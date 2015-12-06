package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nakoryakov on 05.12.15.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        ConsoleHelper.writeMessage("Choose dishes: " + Dish.allDishesToString());
        String dish;
        while (true){
            dish = readString();
            if (dish.equalsIgnoreCase("exit")) break;
            try {
                order.add(Dish.valueOf(dish));
            }
            catch(IllegalArgumentException e) {
                writeMessage(String.format("%s is not detected", dish));
            }
        }
        return order;
    }
}
