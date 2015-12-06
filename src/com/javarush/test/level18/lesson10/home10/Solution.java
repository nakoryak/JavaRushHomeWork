package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> fileNames = new ArrayList<>();
        Scanner consoleReader = new Scanner(System.in);
        while(consoleReader.hasNext())
        {
            String temp = consoleReader.nextLine();
            if (temp.equals("end")) {
                break;
            }
            fileNames.add(temp);

        }
        Collections.sort(fileNames);
        byte[][] buffer = new byte[fileNames.size()][];
        int n = 0;
        for (String fileName: fileNames){
            InputStream fis = new FileInputStream(fileName);
            byte[] file = new byte[fis.available()];
            fis.read(file);
            buffer[n] = file;
            n++;
            fis.close();
        }
        OutputStream fos = new FileOutputStream(fileNames.get(0).replaceAll(".part\\d", ""));
        for (byte[] bytes: buffer){
            fos.write(bytes);
        }
        consoleReader.close();
        fos.close();
    }
}
