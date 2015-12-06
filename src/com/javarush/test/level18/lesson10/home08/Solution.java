package com.javarush.test.level18.lesson10.home08;


import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String temp = consoleReader.readLine();
            if (temp.equals("exit")) break;;
            Thread thread = new ReadThread(temp);
            thread.start();
            thread.join();
        }
        /*for (Map.Entry<String, Integer> map: resultMap.entrySet()){
            System.out.println(map.getKey() + " " + map.getValue());
        }*/
        consoleReader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            try(FileInputStream fis = new FileInputStream(fileName)) {
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                Map<Byte, Integer> map = new HashMap<>();
                for (byte b: bytes){
                    if (map.containsKey(b)){
                        map.put(b, map.get(b) + 1);
                    }
                    else {
                        map.put(b, 0);
                    }
                }
                int index = 0;
                int temp = 0;
                for (Map.Entry<Byte, Integer> m: map.entrySet()){
                    if (m.getValue() > temp){
                        index = m.getKey();
                    }
                }
                resultMap.put(fileName, index);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
