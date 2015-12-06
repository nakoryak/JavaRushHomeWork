package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFileName));
        while (fileReader.ready()){
            for (String str: fileReader.readLine().split(" ")) {
                //int digit = new BigDecimal(str).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
                int d = Math.round(Float.parseFloat(str));
                //System.out.println(digit);
                fileWriter.write(d + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
