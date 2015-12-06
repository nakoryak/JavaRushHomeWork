package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        switch (args[0]){
            case "-e" : shifr(args[1], args[2]);
                break;
            case "-d" : deShifr(args[1], args[2]);
                break;
        }

    }
    public static void shifr(String inputFileName, String outputFileName){
        try(FileReader fis = new FileReader(inputFileName);
            FileWriter fos = new FileWriter(outputFileName))
        {
            while (fis.ready()){
            fos.write(fis.read() + 1);}
        }
        catch (IOException e){
            e.getMessage();
        }
    }
    public static void deShifr(String inputFileName, String outputFileName){
        try(FileReader fis = new FileReader(inputFileName);
            FileWriter fos = new FileWriter(outputFileName))
        {
            while (fis.ready()){
            fos.write(fis.read() - 1);}
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
