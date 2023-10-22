package org.example.lesson3.seminar;

import java.io.DataInput;
import java.io.InputStream;
import java.io.Serializable;

/*
Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K),
конструктор, принимающий на вход параметры типа (T, V, K), методы
возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
классов для трех переменных класса. Наложить ограничения на параметры типа:
T должен реализовать интерфейс Comparable (классы оболочки, String),
V должен реализовать интерфейс DataInput и расширять класс InputStream,
K должен расширять класс Number.
*/
public class FirstClass <T extends Comparable, V extends DataInput, K extends Number> {
    T comparableItem;
    V dataItem;
    K numberItem;

    FirstClass(T comparableItem, V dataItem, K numberItem) {
        this.comparableItem = comparableItem;
        this.dataItem = dataItem;
        this.numberItem = numberItem;
    }

    void getNamesClass() {
        System.out.println(comparableItem.getClass().getName());
        System.out.println(dataItem.getClass().getName());
        System.out.println(numberItem.getClass().getName());
    }
}
