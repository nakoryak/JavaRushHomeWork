package com.javarush.test.level22.lesson05.task01;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();

        int[] indexes = new int[5];
        char[] chars = string.toCharArray();
        int j = 0;

        for (int i = 0; i < chars.length; i++){
            if (String.valueOf(chars[i]).equals(" ")) {
                if (j > indexes.length - 1) break;
                indexes[j] = i;
                j++;
            }
        }
        if (j < 5) throw new TooShortStringException();

        return string.substring(indexes[0] + 1, indexes[4]);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
