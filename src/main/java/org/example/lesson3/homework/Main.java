package org.example.lesson3.homework;

public class Main {
    public static void main(String[] args) {
//        Integer[] array1 = {1, 2, 3};
//        Integer[] array2 = {1, 2, 3};
        String[] array1 = {"1", "2", "3"};
        String[] array2 = {"1", "2", "3"};

        System.out.println(compareArrays(array1, array2));

        Pair<String, Integer> pair = new Pair<>("This is", 5);
        System.out.println(pair);

    }

    /*
    Напишите обобщенный метод compareArrays(),
    который принимает два массива и возвращает true, если они одинаковые,
    и false в противном случае. Массивы могут быть любого типа данных,
    но должны иметь одинаковую длину и содержать элементы одного типа.
     */

    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) return false;
        }
        return true;
    }

}
