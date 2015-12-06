package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return (first == solution.first || solution.first !=null && first.equals(solution.first)) || (last == solution.last &&
                (solution.last != null && last.equals(solution.last)));

    }

    @Override
    public int hashCode() {
        int result = (first == null ? 0 : first.hashCode());
        result = 31 * result + (last == null ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));
        s.add(new Solution("first", null));
        System.out.println(s.contains(new Solution("first", null)));
        s.add(new Solution(null, "last"));
        System.out.println(s.contains(new Solution(null, "last")));
    }
}
