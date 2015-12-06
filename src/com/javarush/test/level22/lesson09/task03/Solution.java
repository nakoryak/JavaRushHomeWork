package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    private static String fileName;
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        Scanner scanner = new Scanner(Paths.get(fileName));
        String temp = "";
        while (scanner.hasNext()){
            temp += scanner.next() + " ";
        }
        StringBuilder result = getLine(temp.split(" "));
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words) throws IOException {
        if (words == null || words.length == 0) return new StringBuilder();
        if (words[0].equals("") || words.length == 1) return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        List<String> listOfStrings = new ArrayList<>();
        for (String str: words){
            sb.append(str + " ");
            listOfStrings.add(str);
        }
        while (sb.toString().trim().length() != result.length()){
            result = sortMyList(new ArrayList<>(listOfStrings));
            Collections.shuffle(listOfStrings);
        }

        return result;
    }
    public static StringBuilder sortMyList(List<String> list){
        StringBuilder result = new StringBuilder();
        result.append(list.get(0));
        list.remove(0);
        int k = list.size();
        int j = 0;
        while (k > j){
            for (int i = 0; i < list.size(); i ++){
                if (list.get(i).toString().toLowerCase().startsWith(
                        result.toString().trim().toLowerCase().substring(result.length() - 1, result.length()))){
                    result.append(" " + list.get(i));
                    list.remove(i);
                }
                else if (list.get(i).toString().trim().toLowerCase().endsWith(result.toString().trim().toLowerCase().substring(0, 1))){
                    result.insert(0, list.get(i) + " ");
                    list.remove(i);
                }
            }
            j++;
        }
        return result;
    }

}
