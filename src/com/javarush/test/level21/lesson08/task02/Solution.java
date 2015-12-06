package com.javarush.test.level21.lesson08.task02;


/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
    //    Tree test = new Tree("test", null);
      //  Tree testClone = null;
        try {
            clone = tree.clone();
  //          testClone = test.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
/*
        System.out.println(test);
        System.out.println(testClone);
        System.out.println(test.branches);
        System.out.println(testClone.branches);*/
    }


    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            if (branches == null){
                return new Tree(super.getName(), null);
            }
            else {
                String[] str = new String[getBranches().length];
                for (int i = 0; i < getBranches().length; i++) {
                    str[i] = getBranches()[i];
                }
                Tree result = new Tree(new String(super.getName()), str);
                return result;
            }
        }
    }
}
