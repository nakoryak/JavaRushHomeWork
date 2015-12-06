package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/
// 65-90 97-122
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileContent = "";
        int letterCount = 0;
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            fileContent += reader.readLine();
        }
        for (char ch: fileContent.toCharArray()){
            if (65 <= ch && ch <= 90 || 97 <= ch && ch <= 122 ){
                letterCount++;
            }
        }
        System.out.println(letterCount);
    }
}
