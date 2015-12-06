package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<String> fileNames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileNames.add(reader.readLine());
            while (reader.ready()){
                fileNames.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String str: fileNames){
            try {
                FileInputStream fis = new FileInputStream(str);
            } catch (FileNotFoundException e) {
                System.out.println(str);
            }
        }
    }
}
