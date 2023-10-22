package org.example.lesson3.homework;

/*
Написать класс Калькулятор (необобщенный),
который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
 */
public class Calculator {
    public static <T extends Number, E extends Number> double sum(T first, E second) {
        return first.doubleValue() + second.doubleValue();
    }
    public static <T extends Number, E extends Number> double sub(T first, E second) {
        return first.doubleValue() - second.doubleValue();
    }
    public static <T extends Number, E extends Number> double mul(T first, E second) {
        return first.doubleValue() * second.doubleValue();
    }
    public static <T extends Number, E extends Number> double dev(T first, E second) {
        return first.doubleValue() / second.doubleValue();
    }
}
