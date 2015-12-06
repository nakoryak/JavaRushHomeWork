package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] solutions = new Solution[2];
        solutions[0] = new Solution();
        solutions[1] = new Solution();
        for (Solution sol: solutions){
            sol.innerClasses[0] = new Solution().new InnerClass();
            sol.innerClasses[1] = new Solution().new InnerClass();
        }
        return solutions;
    }
}
