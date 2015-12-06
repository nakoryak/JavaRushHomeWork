package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = consoleReader.readLine();
        String secondFileName = consoleReader.readLine();
        //StringBuffer sb = new StringBuffer();
        InputStream firstFileInputStream = new FileInputStream(firstFileName);
        InputStream secondFileInputStream = new FileInputStream(secondFileName);
        byte firstFile[] = new byte[firstFileInputStream.available()];
        byte secondFile[] = new byte[secondFileInputStream.available()];
        while (secondFileInputStream.available() > 0){
            secondFileInputStream.read(secondFile);
        }
        while (firstFileInputStream.available() > 0){
            firstFileInputStream.read(firstFile);
        }
        firstFileInputStream.close();
        secondFileInputStream.close();

        OutputStream os = new FileOutputStream(firstFileName);
        os.write(secondFile);
        os.write(firstFile);
        os.close();

    }
}
