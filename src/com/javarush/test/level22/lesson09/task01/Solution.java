package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new File(fileName));
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.next());
        }
        scanner.close();
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if (i != j && list.get(i).equals(new StringBuilder(list.get(j)).reverse().toString())){
                    Pair pair = new Pair();
                    pair.first = list.get(i);
                    pair.second = list.get(j);
                    result.add(pair);
                    list.remove(list.get(j));
                }
            }
        }
        //result.stream().forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;


        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
