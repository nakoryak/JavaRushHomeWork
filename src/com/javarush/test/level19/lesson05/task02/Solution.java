package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Pattern world = Pattern.compile("\\bworld\\b", Pattern.CASE_INSENSITIVE);
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            Matcher matcher = world.matcher(reader.readLine());
            while (matcher.find()){
                count++;
            }
        }
        reader.close();
        System.out.println(count);
    }
}
