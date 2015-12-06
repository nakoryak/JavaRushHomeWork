package com.javarush.test.level19.lesson10.bonus01;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        Scanner firstFile = new Scanner(new File(firstFileName));
        Scanner secondFile = new Scanner(new File(secondFileName));

        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();

        while (firstFile.hasNext()){
            firstList.add(firstFile.nextLine());
        }
        while (secondFile.hasNext()){
            secondList.add(secondFile.nextLine());
        }

        firstFile.close();
        secondFile.close();
        List<String> firstListCopy = new ArrayList<>(firstList);
        boolean flag;
        for (int i = 0; i < firstListCopy.size(); i++) {
            flag = true;
            for (String str2: secondList){
                if (firstListCopy.get(i).equals(str2)){
                    lines.add(new LineItem(Type.SAME, firstListCopy.get(i)));
                    flag = false;
                    break;
                }
                else if (!firstList.contains(str2)){
                    lines.add(new LineItem(Type.ADDED, str2));
                    break;
                }
            }
            if (flag) {
                lines.add(new LineItem(Type.REMOVED, firstListCopy.get(i)));
            }
        }
        for (LineItem item: lines){
            System.out.println(item.type + " " + item.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}
