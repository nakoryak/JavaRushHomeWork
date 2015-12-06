package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.*;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        float countSymbols = 0;
        float countSpaces = 0;
        String fileContent = "";
        DataInputStream dis = new DataInputStream(new FileInputStream(args[0]));
        countSymbols = dis.available();
        while (dis.available() > 1){
            //System.out.println(dis.read());
            if (Character.isSpaceChar(dis.read())){
                countSpaces++;
            }
        }
        dis.close();
        System.out.printf(Locale.ENGLISH, "%.2f", (countSpaces / countSymbols) * 100);
    }
}

