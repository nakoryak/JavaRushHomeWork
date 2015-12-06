package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(args[0]));

        Map<Character, Integer> map = new TreeMap<>();
        while (dis.available() > 0){
            char ch = (char)dis.read();
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch)+ 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> mp: map.entrySet()){
            System.out.println(mp.getKey() + " " + mp.getValue());
        }
    }
}
