package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        reader.close();
        FileInputStream firstFis = new FileInputStream(secondFileName);
        FileInputStream secondFis = new FileInputStream(thirdFileName);
        FileWriter writer = new FileWriter(firstFileName);
        FileWriter writer1 = new FileWriter(firstFileName, true);

        while (firstFis.available() > 0){
            writer.write(firstFis.read());
        }
        writer.close();
        while (secondFis.available() > 0){
            writer1.write(secondFis.read());
        }

        firstFis.close();
        secondFis.close();
        writer1.close();
    }
}
