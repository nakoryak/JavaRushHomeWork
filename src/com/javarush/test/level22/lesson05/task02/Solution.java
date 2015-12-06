package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
        if (string == null || string.isEmpty() || string.equals("") || string.length() < 1) throw new TooShortStringException();

            int first = string.indexOf('\t');
            int second = string.indexOf('\t', first + 1);
            return string.substring(first + 1, second);}
        catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tmama\t"));
    }

    public static class TooShortStringException extends Exception {
    }
}
