package org.example.lesson3.seminar;

import org.example.lesson3.homework.nightclub.*;

import java.io.*;

/*
Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K),
конструктор, принимающий на вход параметры типа (T, V, K), методы
возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
классов для трех переменных класса. Наложить ограничения на параметры типа:
T должен реализовать интерфейс Comparable (классы оболочки, String),
V должен реализовать интерфейс DataInput и расширять класс InputStream,
K должен расширять класс Number.
*/

/*
Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
*/
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new DataInputStream(new FileInputStream("test.txt"));
        FirstClass<String, DataInputStream, Integer> fc = new FirstClass<>("any", new DataInputStream(is), 3);
        fc.getNamesClass();

        Person person1 = new HardWorker();
        Person person2 = new HardWorker();
        Person person3 = new HardWorker();
        Person person4 = new HardWorker();
        Person person5 = new HardWorker();
        Person person6 = new Idler();
        Person person7 = new Idler();
        Person person8 = new Idler();
        Person person9 = new Idler();
        Person person10 = new Idler();

        Person[] workers = {person1, person7, person3, person9, person5};
        Person[] idlers = {person6, person2, person8, person4, person10};

        WorkPlace<? extends Person> factory = new WorkPlace<>(workers);
        NightClub<? extends Person> club = new NightClub<>(idlers);

        factory.workForAll();
        club.partyForAll();

    }
}

