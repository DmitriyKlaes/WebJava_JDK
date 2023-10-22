package org.example.lesson3.homework;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair <T, E> {

    private T firstValue;
    private E secondValue;

    public Pair(T firstValue, E secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public E getSecondValue() {
        return secondValue;
    }

    @Override
    public String toString() {
        return firstValue + " " + secondValue;
    }
}
