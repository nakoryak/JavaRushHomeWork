package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by nakoryakov on 06.09.15.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer,Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    public void addAmount(int denomination, int count){
        denominations.put(denomination, count);
    }
    public int getTotalAmount(){
        int count = 0;
        for (Map.Entry<Integer, Integer> denominationMap : denominations.entrySet()){
            count += denominationMap.getKey() * denominationMap.getValue();
        }
        return count;
    }
    public boolean hasMoney(){
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount <= this.getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = new HashMap<>();
        Integer tempAmount = expectedAmount;
        List<Integer> currents = new ArrayList<>(denominations.keySet());
        Collections.sort(currents, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer current: currents){
            int denominationAmount = tempAmount / current;
            if (denominationAmount != 0){
                if (denominations.get(current) >= denominationAmount){
                    denominations.put(current, denominations.get(current) - denominationAmount);
                    result.put(current, denominationAmount);
                    tempAmount = tempAmount % current;
                }
                else continue;
            }

        }
        if (tempAmount > 0) throw new NotEnoughMoneyException();
        return result;
    }
}
