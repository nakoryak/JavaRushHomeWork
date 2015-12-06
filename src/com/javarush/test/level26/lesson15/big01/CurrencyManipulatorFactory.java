package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nakoryakov on 06.09.15.
 */
public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (manipulators.containsKey(currencyCode)){
            return manipulators.get(currencyCode);
        }
        else {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, currencyManipulator);
            return currencyManipulator;
        }
    }

    public static Collection<String> getAllCurrencyManipulators(){
        return manipulators.keySet();
    }

    private CurrencyManipulatorFactory() {
    }
}
